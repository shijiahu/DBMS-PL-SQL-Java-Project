create or replace package proj2_v1 as
type ref_cursor is ref cursor;
function show_employees
	return ref_cursor;
function show_customers
	return ref_cursor;
function show_products
        return ref_cursor;
function show_discounts
        return ref_cursor;
function show_suppliers
        return ref_cursor;
function show_supplies
        return ref_cursor;
function show_purchases
        return ref_cursor;
function show_logs
        return ref_cursor;
function purchase_saving
        (pur_no in purchases.pur#%type)
        return number;
procedure add_customer(
        c_id in customers.cid%type,
        c_name in customers.name%type,
        c_telephone# in customers.telephone#%type);

function monthly_sale_activities(
        employee_id in employees.eid%type) 
        return ref_cursor;

procedure monthly_sale_activities2(
employee_id in employees.eid%type,
rc out ref_cursor,
status out integer);

procedure add_purchase(
e_id in purchases.eid%type,
p_id in purchases.pid%type,
c_id in purchases.cid%type,
pur_qty in purchases.qty%type,
output1 out varchar,
new_qty out number);

procedure delete_purchase (
	pur_no in purchases.pur#%type);


end;
/
show errors


create or replace package body proj2_v1 as
function show_employees
	return ref_cursor is
	rc ref_cursor;
begin
	open rc for
	select * from employees;
	return rc;
end;
function show_customers
        return ref_cursor is
        rc ref_cursor;
begin
        open rc for
        select * from customers;
        return rc;
end;
function show_products
        return ref_cursor is
        rc ref_cursor;
begin
        open rc for
        select * from products;
        return rc;
end;
function show_discounts
        return ref_cursor is
        rc ref_cursor;
begin
        open rc for
        select * from discounts;
        return rc;
end;
function show_suppliers
        return ref_cursor is
        rc ref_cursor;
begin
        open rc for
        select * from suppliers;
        return rc;
end;
function show_supplies
        return ref_cursor is
        rc ref_cursor;
begin
        open rc for
        select * from supplies;
        return rc;
end;
function show_purchases
        return ref_cursor is
        rc ref_cursor;
begin
        open rc for
        select * from purchases;
        return rc;
end;
function show_logs
        return ref_cursor is
        rc ref_cursor;
begin
        open rc for
        select * from logs;
        return rc;
end;

function purchase_saving
	(pur_no in purchases.pur#%type)
	return number is
	pur_saving number;
begin
	select qty*original_price - total_price into pur_saving
	from purchases pur, products p
	where pur# = pur_no
	and pur.pid = p.pid;
	return pur_saving;
exception
	when others then
        	dbms_output.put_line('Error: Pur# value is invalid.');
end;

procedure add_customer(
	c_id in customers.cid%type,
	c_name in customers.name%type,
	c_telephone# in customers.telephone#%type) is
begin
	insert into customers values
	(c_id, c_name, c_telephone#, 1, sysdate);
end;


function monthly_sale_activities(
employee_id in employees.eid%type) 
return ref_cursor is
c1 ref_cursor;
begin      
open c1 for
select * 
from 
(select eid, name from employees where eid = employee_id),  
(select MON, YEAR, count(*) sales_times,sum(qty) sales_qty, sum(total_price) sales_amount from 
(select to_char(ptime,'MON') MON, to_char(ptime, 'YYYY') YEAR, qty, total_price from purchases where eid = employee_id) 
group by MON, YEAR);
return c1;
end;


procedure monthly_sale_activities2(
employee_id in employees.eid%type,
rc out ref_cursor,
status out integer) is
e_id employees.eid%type;

begin

        open rc for
        select unique e.eid, e.name, to_char(p.ptime, 'MON') month, to_char(p.ptime, 'YYYY') year, sales_times,  total_quantity, total_dollar_amount 
from employees e, purchases p, 
(select to_char(ptime, 'MON') month, count(*) sales_times, sum(qty) total_quantity, sum(total_price) total_dollar_amount 
from purchases 
where eid = employee_id
group by to_char(ptime, 'MON')) temp 
where e.eid = employee_id and e.eid = p.eid and to_char(p.ptime, 'MON') = temp.month;


        status := 0;

        select eid into e_id from employees where eid = employee_id;

        exception
        when NO_DATA_FOUND then
        status := 1;

end;

procedure delete_purchase (
pur_no in purchases.pur#%type) is
temp_pur_no purchases.pur#%type;


begin

select pur# into temp_pur_no from purchases where pur# = pur_no;

delete from purchases/*delete the tuple with the pur# inputted*/
where pur# = pur_no;

exception
when others then
	dbms_output.put_line('Error: Pur# value is invalid.');


end;
procedure add_purchase(
e_id in purchases.eid%type,
p_id in purchases.pid%type,
c_id in purchases.cid%type,
pur_qty in purchases.qty%type,
output1 out varchar,
new_qty out number) is /* things should be print : message and the update of qoh*/
temp_e_id employees.eid%type;
temp_p_id products.pid%type;
temp_c_id customers.cid%type;

next_pur_no NUMBER;	/*automatically generated by my sequence*/
temp_amount purchases.total_price%type;/*store the new total price computed by original price*/
temp_qoh products.qoh%type;/*store the quantity on hand(qoh) to be compared*/
temp_qoh_threshold products.qoh_threshold%type;/*store the selected qoh_threshold to be compared with qoh*/

negative_qty exception;



begin
	select eid into temp_e_id from employees where eid = e_id;
	select pid into temp_p_id from products where pid = p_id;
	select cid into temp_c_id from customers where cid = c_id;
	select pur_seq.NEXTVAL into next_pur_no from dual;/*automatically generated by my sequence*/

	select original_price * (1 - discnt_rate) * pur_qty into temp_amount 
    from products, 
    (select discnt_rate from products p, discounts d where pid = p_id and p.discnt_category = d.discnt_category) 
    where pid = p_id;  /*store the new total price computed by original price*/

	select qoh into temp_qoh from products where pid = p_id;/*store the quantity on hand(qoh) to be compared*/

	if (temp_qoh < pur_qty) then/*compare the quantity to be purchased and qoh*/
	/*the quantity to be purchased is larger than the quantity on hand (qoh). */
	/*the purchase request should be rejected.*/
      	raise negative_qty;
    else/*the quantity to be purchased is equal to or smaller than the quantity on hand (qoh)*/
    	/*able to insert new ourchases*/
    	select qoh_threshold into temp_qoh_threshold from products where pid = p_id;
		/*store the selected qoh_threshold to be compared with qoh*/
		temp_qoh := temp_qoh - pur_qty;

		/*condition of print messages*/
		if (temp_qoh < temp_qoh_threshold) then
			output1 := 'Current qoh of the product is below the required threshold and new supply is required';
			new_qty := (temp_qoh_threshold - temp_qoh + 1) + temp_qoh + 10 + temp_qoh;
		end if;

		insert into purchases values(next_pur_no, e_id, p_id, c_id, pur_qty, sysdate, temp_amount);
		
		



    end if;
	exception
	   	when negative_qty then
	   	/*say there is no sufficient quantity in stock*/
	    raise_application_error(-20001, 'Insufficient quantity in stock');
	when NO_DATA_FOUND then
		dbms_output.put_line('Error: inserted value is invalid.');

end;

end;
/
show errors
