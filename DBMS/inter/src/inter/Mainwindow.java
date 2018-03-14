package inter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import oracle.net.aso.q;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class Mainwindow {

	private JFrame frame;
	private JPanel panelmain;
	private JPanel show_employees;
	private JPanel show_customers;
	private JPanel show_products;
	private JPanel show_discounts;
	private JPanel show_suppliers;
	private JPanel show_supplies;
	private JPanel show_purchases;
	private JPanel show_logs;
	private JPanel purchase_saving;
	private JPanel monthly_sale_activities;
	private JPanel add_customer;
	private JPanel add_purchase;
	private JPanel delete_purchase;
	private JTextField pur_number;
	private JTextField q4_eid;
	private JTextField add_cid;
	private JTextField c_name;
	private JTextField c_telephone;
	private JTextField e7_id;
	private JTextField p7_id;
	private JTextField c7_id;
	private JTextField pur_qty;
	private JTextField p_number;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainwindow window = new Mainwindow();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 955, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panelmain = new JPanel();
		frame.getContentPane().add(panelmain, "name_12401299432399");
		panelmain.setLayout(null);
		final JPanel show_employees = new JPanel();
		frame.getContentPane().add(show_employees, "name_12403920355893");
		final JPanel show_customers = new JPanel();
		frame.getContentPane().add(show_customers, "name_12405627981281");
		show_customers.setLayout(null);
		
		
		JTextArea show_customer_text = new JTextArea();
		show_customer_text.setBounds(241, 39, 596, 495);
		show_customers.add(show_customer_text);
		JButton btnShow_1 = new JButton("show");
		btnShow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test2 t2 = new test2();
				try {
					String customer_result = t2.tes();
					show_customer_text.setText(customer_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_1.setBounds(37, 30, 167, 58);
		show_customers.add(btnShow_1);
		
		JButton btnNewButton = new JButton("go back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				show_customers.setVisible(false);
			}
		});
		btnNewButton.setBounds(37, 123, 167, 50);
		show_customers.add(btnNewButton);
		
		
		
		final JPanel show_products = new JPanel();
		frame.getContentPane().add(show_products, "name_12407412522772");
		show_products.setLayout(null);
		
		
		JTextArea show_products_text = new JTextArea();
		show_products_text.setBounds(256, 33, 668, 505);
		show_products.add(show_products_text);
		JButton btnShow_2 = new JButton("show");
		btnShow_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_show_products p2 = new C_show_products();
				try {
					String show_products_result = p2.products();
					show_products_text.setText(show_products_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_2.setBounds(37, 33, 176, 52);
		show_products.add(btnShow_2);
		
		
		
		JButton btnGoBack_1 = new JButton("go back");
		btnGoBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				show_products.setVisible(false);
			}
		});
		btnGoBack_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_1.setBounds(37, 119, 176, 52);
		show_products.add(btnGoBack_1);
		
		
		
		final JPanel show_discounts = new JPanel();
		frame.getContentPane().add(show_discounts, "name_12418859701146");
		show_discounts.setLayout(null);
		
		JTextArea show_discounts_text = new JTextArea();
		show_discounts_text.setBounds(284, 41, 561, 484);
		show_discounts.add(show_discounts_text);
		
		JButton btnNewButton_1 = new JButton("show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_show_discounts dis2 = new C_show_discounts();
				try {
					String show_discounts_result = dis2.discounts();
					show_discounts_text.setText(show_discounts_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(61, 41, 157, 60);
		show_discounts.add(btnNewButton_1);
		
		JButton btnGoBack_2 = new JButton("go back");
		btnGoBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				show_discounts.setVisible(false);
			}
		});
		btnGoBack_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_2.setBounds(61, 144, 157, 52);
		show_discounts.add(btnGoBack_2);
		
		
		
		final JPanel show_suppliers = new JPanel();
		frame.getContentPane().add(show_suppliers, "name_13154749876555");
		show_suppliers.setLayout(null);
		
		
		JTextArea show_suppliers_text = new JTextArea();
		show_suppliers_text.setBounds(244, 33, 637, 501);
		show_suppliers.add(show_suppliers_text);
		JButton btnShow_3 = new JButton("show");
		btnShow_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_show_suppliers sup2 = new C_show_suppliers();
				try {
					String show_suppliers_result = sup2.suppliers();
					show_suppliers_text.setText(show_suppliers_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_3.setBounds(39, 33, 169, 69);
		show_suppliers.add(btnShow_3);
		
		JButton btnGoBack_3 = new JButton("go back");
		btnGoBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				show_suppliers.setVisible(false);
			}
		});
		btnGoBack_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_3.setBounds(37, 129, 171, 58);
		show_suppliers.add(btnGoBack_3);
		
		
		
		final JPanel show_supplies = new JPanel();
		frame.getContentPane().add(show_supplies, "name_13156307091520");
		show_supplies.setLayout(null);
		
		
		JTextArea show_supplies_text = new JTextArea();
		show_supplies_text.setBounds(217, 33, 632, 507);
		show_supplies.add(show_supplies_text);
		JButton btnShow_4 = new JButton("show");
		btnShow_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_show_supplies su2 = new C_show_supplies();
				try {
					String show_supplies_result = su2.supplies();
					show_supplies_text.setText(show_supplies_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_4.setBounds(36, 33, 162, 56);
		show_supplies.add(btnShow_4);
		
		JButton btnGoBack_4 = new JButton("go back");
		btnGoBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				show_supplies.setVisible(false);
			}
		});
		btnGoBack_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_4.setBounds(36, 121, 162, 45);
		show_supplies.add(btnGoBack_4);
		
		
		
		final JPanel show_purchases = new JPanel();
		frame.getContentPane().add(show_purchases, "name_13157838149561");
		show_purchases.setLayout(null);
		
		
		JTextArea show_purchases_text = new JTextArea();
		show_purchases_text.setBounds(191, 38, 734, 500);
		show_purchases.add(show_purchases_text);
		JButton btnShow_5 = new JButton("show");
		btnShow_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_show_purchases pu2 = new C_show_purchases();
				try {
					String show_purchases_result = pu2.purchases();
					show_purchases_text.setText(show_purchases_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_5.setBounds(12, 39, 167, 54);
		show_purchases.add(btnShow_5);
		
		JButton btnGoBack_5 = new JButton("go back");
		btnGoBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				show_purchases.setVisible(false);
			}
		});
		btnGoBack_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_5.setBounds(12, 127, 167, 48);
		show_purchases.add(btnGoBack_5);
		
		
		
		final JPanel show_logs = new JPanel();
		frame.getContentPane().add(show_logs, "name_13286117291711");
		show_logs.setLayout(null);
		
		
		JTextArea show_logs_text = new JTextArea();
		show_logs_text.setBounds(221, 43, 703, 493);
		show_logs.add(show_logs_text);
		JButton btnShow_6 = new JButton("show");
		btnShow_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_show_logs logs = new C_show_logs();
				try {
					String log_result = logs.logs();
					show_logs_text.setText(log_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_6.setBounds(52, 43, 157, 52);
		show_logs.add(btnShow_6);
		
		JButton btnGoBack_6 = new JButton("go back");
		btnGoBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				show_logs.setVisible(false);
			}
		});
		btnGoBack_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_6.setBounds(51, 123, 158, 52);
		show_logs.add(btnGoBack_6);
		
		
		
		final JPanel purchase_saving = new JPanel();
		frame.getContentPane().add(purchase_saving, "name_13287706231608");
		purchase_saving.setLayout(null);
		
		pur_number = new JTextField();
		pur_number.setBounds(116, 24, 116, 22);
		purchase_saving.add(pur_number);
		pur_number.setColumns(10);
		
		JLabel lblPur = new JLabel("pur#");
		lblPur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPur.setBounds(36, 27, 56, 16);
		purchase_saving.add(lblPur);
		
		
		JTextArea purchase_saving_text = new JTextArea();
		purchase_saving_text.setBounds(305, 54, 559, 492);
		purchase_saving.add(purchase_saving_text);
		JButton btnShow_7 = new JButton("Submit");
		btnShow_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = pur_number.getText();
				
				C_purchase_saving ps2 = new C_purchase_saving();
				try {
					String purchase_saving_result = ps2.purchase_saving(s1);
					purchase_saving_text.setText(purchase_saving_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_7.setBounds(56, 59, 176, 43);
		purchase_saving.add(btnShow_7);
		
		JButton btnGoBack_7 = new JButton("go back");
		btnGoBack_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				purchase_saving.setVisible(false);
			}
		});
		btnGoBack_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_7.setBounds(56, 138, 176, 51);
		purchase_saving.add(btnGoBack_7);
		
		
		
		final JPanel monthly_sale_activities = new JPanel();
		frame.getContentPane().add(monthly_sale_activities, "name_13292858157144");
		monthly_sale_activities.setLayout(null);
		
		q4_eid = new JTextField();
		q4_eid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		q4_eid.setBounds(68, 28, 158, 38);
		monthly_sale_activities.add(q4_eid);
		q4_eid.setColumns(10);
		
		JLabel lblEid = new JLabel("eid");
		lblEid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEid.setBounds(23, 37, 56, 16);
		monthly_sale_activities.add(lblEid);
		
		
		JTextArea monthly_sale_result = new JTextArea();
		monthly_sale_result.setBounds(246, 28, 679, 517);
		monthly_sale_activities.add(monthly_sale_result);
		JButton btnShow_8 = new JButton("Submit");
		btnShow_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q44_eid = q4_eid.getText();
				C_monthly_sale_activities mon = new C_monthly_sale_activities();
				try {
					String monthly_reuslt = mon.monthly_sale_activities(q44_eid);
					monthly_sale_result.setText(monthly_reuslt);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_8.setBounds(68, 89, 166, 45);
		monthly_sale_activities.add(btnShow_8);
		
		JButton btnGoBack_8 = new JButton("go back");
		btnGoBack_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				monthly_sale_activities.setVisible(false);
			}
		});
		btnGoBack_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_8.setBounds(68, 159, 166, 38);
		monthly_sale_activities.add(btnGoBack_8);
		
		
		
		final JPanel add_customer = new JPanel();
		frame.getContentPane().add(add_customer, "name_13294809524634");
		add_customer.setLayout(null);
		
		add_cid = new JTextField();
		add_cid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add_cid.setBounds(117, 30, 151, 40);
		add_customer.add(add_cid);
		add_cid.setColumns(10);
		
		c_name = new JTextField();
		c_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		c_name.setBounds(116, 95, 152, 40);
		add_customer.add(c_name);
		c_name.setColumns(10);
		
		c_telephone = new JTextField();
		c_telephone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		c_telephone.setBounds(117, 161, 151, 40);
		add_customer.add(c_telephone);
		c_telephone.setColumns(10);
		
		JLabel lblCid = new JLabel("c_id");
		lblCid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCid.setBounds(49, 42, 56, 16);
		add_customer.add(lblCid);
		
		JLabel lblCname = new JLabel("c_name");
		lblCname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCname.setBounds(37, 100, 69, 28);
		add_customer.add(lblCname);
		
		JLabel lblCtelephone = new JLabel("c_telephone");
		lblCtelephone.setBounds(24, 173, 81, 16);
		add_customer.add(lblCtelephone);
		
		
		JTextArea add_customer_text = new JTextArea();
		add_customer_text.setBounds(324, 30, 563, 479);
		add_customer.add(add_customer_text);
		JButton btnShow_9 = new JButton("Submit");
		btnShow_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q5_cid = add_cid.getText();
				String q5_name = c_name.getText();
				String q5_telephone = c_telephone.getText();
				C_add_customer ac3 = new C_add_customer();
				try {
					String add_customer_result = ac3.add_customer(q5_cid, q5_name, q5_telephone);
					add_customer_text.setText(add_customer_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow_9.setBounds(49, 232, 185, 48);
		add_customer.add(btnShow_9);
		
		JButton btnGoBack_9 = new JButton("go back");
		btnGoBack_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				add_customer.setVisible(false);
			}
		});
		btnGoBack_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_9.setBounds(49, 310, 185, 40);
		add_customer.add(btnGoBack_9);
		
		
		
		final JPanel add_purchase = new JPanel();
		frame.getContentPane().add(add_purchase, "name_13296953215048");
		add_purchase.setLayout(null);
		
		e7_id = new JTextField();
		e7_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		e7_id.setBounds(107, 23, 153, 36);
		add_purchase.add(e7_id);
		e7_id.setColumns(10);
		
		p7_id = new JTextField();
		p7_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		p7_id.setBounds(105, 87, 155, 36);
		add_purchase.add(p7_id);
		p7_id.setColumns(10);
		
		c7_id = new JTextField();
		c7_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		c7_id.setBounds(107, 149, 153, 36);
		add_purchase.add(c7_id);
		c7_id.setColumns(10);
		
		JLabel lblPid = new JLabel("e_id");
		lblPid.setBounds(39, 33, 56, 16);
		add_purchase.add(lblPid);
		
		JLabel lblCid_1 = new JLabel("p_id");
		lblCid_1.setBounds(37, 97, 56, 16);
		add_purchase.add(lblCid_1);
		
		JLabel lblCid_2 = new JLabel("c_id");
		lblCid_2.setBounds(37, 159, 56, 16);
		add_purchase.add(lblCid_2);
		
		pur_qty = new JTextField();
		pur_qty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pur_qty.setBounds(106, 209, 154, 36);
		add_purchase.add(pur_qty);
		pur_qty.setColumns(10);
		
		JLabel lblPurqty = new JLabel("pur_qty");
		lblPurqty.setBounds(39, 219, 56, 16);
		add_purchase.add(lblPurqty);
		
		
		JTextArea add_purchase_text = new JTextArea();
		add_purchase_text.setBounds(272, 30, 653, 497);
		add_purchase.add(add_purchase_text);
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q7_eid = e7_id.getText();
				String q7_pid = p7_id.getText();
				String q7_cid = c7_id.getText();
				String q7_qty = pur_qty.getText();
				int q7_qty2 = Integer.parseInt(q7_qty);
				C_add_purchase ad = new C_add_purchase();
				try {
					String ad_purchase = ad.add_purchase(q7_eid, q7_cid, q7_pid, q7_qty2);
					add_purchase_text.setText(ad_purchase);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(70, 282, 170, 45);
		add_purchase.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("go back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				add_purchase.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setBounds(70, 355, 170, 45);
		add_purchase.add(btnNewButton_3);
		
		
		
		final JPanel delete_purchase = new JPanel();
		frame.getContentPane().add(delete_purchase, "name_13391943380813");
		delete_purchase.setLayout(null);
		
		p_number = new JTextField();
		p_number.setFont(new Font("Tahoma", Font.PLAIN, 15));
		p_number.setBounds(109, 29, 166, 42);
		delete_purchase.add(p_number);
		p_number.setColumns(10);
		
		JLabel lblPur_1 = new JLabel("pur#");
		lblPur_1.setBounds(30, 42, 56, 16);
		delete_purchase.add(lblPur_1);
		
		
		JTextArea delete_purchase_text = new JTextArea();
		delete_purchase_text.setBounds(316, 50, 544, 476);
		delete_purchase.add(delete_purchase_text);
		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q8_p = p_number.getText();
				C_delete_purchase q8 = new C_delete_purchase();
				try {
					String delete_purchase_result = q8.delete_purchase(q8_p);
					delete_purchase_text.setText(delete_purchase_result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_4.setBounds(70, 101, 166, 50);
		delete_purchase.add(btnNewButton_4);
		
		JButton btnGoBack_10 = new JButton("go back");
		btnGoBack_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				delete_purchase.setVisible(false);
			}
		});
		btnGoBack_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack_10.setBounds(70, 174, 166, 50);
		delete_purchase.add(btnGoBack_10);
		
		
		
		panelmain.setVisible(true);
		show_employees.setVisible(false);
		show_customers.setVisible(false);
		show_products.setVisible(false);
		show_discounts.setVisible(false);
		show_suppliers.setVisible(false);
		show_supplies.setVisible(false);
		show_purchases.setVisible(false);
		show_logs.setVisible(false);
		purchase_saving.setVisible(false);
		add_customer.setVisible(false);
		monthly_sale_activities.setVisible(false);
		add_purchase.setVisible(false);
		delete_purchase.setVisible(false);
		
		
		
		JButton btnShowemployees = new JButton("show_employees");
		btnShowemployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				show_employees.setVisible(true);
			}
		});
		btnShowemployees.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowemployees.setBounds(66, 53, 245, 39);
		panelmain.add(btnShowemployees);
		
		JButton btnShowcustomers = new JButton("show_customers");
		btnShowcustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				show_customers.setVisible(true);
			}
		});
		btnShowcustomers.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowcustomers.setBounds(66, 105, 245, 40);
		panelmain.add(btnShowcustomers);
		
		JButton btnShowproducts = new JButton("show_products");
		btnShowproducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				show_products.setVisible(true);
			}
		});
		btnShowproducts.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowproducts.setBounds(66, 158, 245, 39);
		panelmain.add(btnShowproducts);
		
		JButton btnShowdiscounts = new JButton("show_discounts");
		btnShowdiscounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				show_discounts.setVisible(true);
			}
		});
		btnShowdiscounts.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowdiscounts.setBounds(64, 214, 247, 44);
		panelmain.add(btnShowdiscounts);
		
		JButton btnShowsupliers = new JButton("show_supliers");
		btnShowsupliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				show_suppliers.setVisible(true);
			}
		});
		btnShowsupliers.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowsupliers.setBounds(62, 271, 249, 41);
		panelmain.add(btnShowsupliers);
		
		JButton btnShowsuplies = new JButton("show_suplies");
		btnShowsuplies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				show_supplies.setVisible(true);
			}
		});
		btnShowsuplies.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowsuplies.setBounds(62, 325, 249, 51);
		panelmain.add(btnShowsuplies);
		
		JButton btnShowpurchases = new JButton("show_purchases");
		btnShowpurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				show_purchases.setVisible(true);
			}
		});
		btnShowpurchases.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowpurchases.setBounds(59, 399, 252, 51);
		panelmain.add(btnShowpurchases);
		
		JButton btnShowlogs = new JButton("show_logs");
		btnShowlogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				show_logs.setVisible(true);
			}
		});
		btnShowlogs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowlogs.setBounds(498, 53, 245, 51);
		panelmain.add(btnShowlogs);
		
		JButton btnPurchasesaving = new JButton("purchase_saving");
		btnPurchasesaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				purchase_saving.setVisible(true);
			}
		});
		btnPurchasesaving.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPurchasesaving.setBounds(498, 115, 245, 44);
		panelmain.add(btnPurchasesaving);
		
		JButton btnMonthlysaleactivities = new JButton("monthly_sale_activities");
		btnMonthlysaleactivities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				monthly_sale_activities.setVisible(true);
			}
		});
		btnMonthlysaleactivities.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMonthlysaleactivities.setBounds(498, 187, 245, 51);
		panelmain.add(btnMonthlysaleactivities);
		
		JButton btnAddcustomer = new JButton("add_customer");
		btnAddcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				add_customer.setVisible(true);
			}
		});
		btnAddcustomer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddcustomer.setBounds(498, 251, 245, 61);
		panelmain.add(btnAddcustomer);
		
		JButton btnAddpurchase = new JButton("add_purchase");
		btnAddpurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				add_purchase.setVisible(true);
			}
		});
		btnAddpurchase.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddpurchase.setBounds(495, 325, 248, 51);
		panelmain.add(btnAddpurchase);
		
		JButton btnDeletepurchase = new JButton("delete_purchase");
		btnDeletepurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(false);
				delete_purchase.setVisible(true);
			}
		});
		btnDeletepurchase.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeletepurchase.setBounds(498, 399, 245, 51);
		panelmain.add(btnDeletepurchase);
		
		
		show_employees.setLayout(null);
		
		JTextArea show_employees_text = new JTextArea();
		show_employees_text.setBounds(228, 40, 625, 497);
		show_employees.add(show_employees_text);
		
		JButton btnShow = new JButton("show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_show_employees s2 = new C_show_employees();
				try {
					String result = s2.employees();
					show_employees_text.setText(result);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShow.setBounds(35, 39, 153, 47);
		show_employees.add(btnShow);
		
		JButton btnGoBack = new JButton("go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelmain.setVisible(true);
				show_employees.setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack.setBounds(35, 112, 153, 39);
		show_employees.add(btnGoBack);
		
		
	}
}
