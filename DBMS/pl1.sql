drop sequence pur_seq;
drop sequence sup_seq;
drop sequence log_seq;

create sequence log_seq
minvalue 10000
maxvalue 99999
start with 10000
increment by 1
cache 20;

declare
	purmax number;	
	supmax number;
	logmax number;
begin
	select max(pur#) + 1
	into purmax
	from purchases;
	select max(sup#) + 1
        into supmax
        from supplies;
	select max(log#) + 1
        into logmax
        from logs;
	execute immediate 'create sequence pur_seq
        		   minvalue 100000
        		   maxvalue 999999
        		   start with ' || purmax ||
        		   'increment by 1
        	           cache 20';
	 execute immediate 'create sequence sup_seq
                           minvalue 1000
                           maxvalue 9999
                           start with ' || supmax ||
                           'increment by 1
                           cache 20';	
end;
/
show errors

