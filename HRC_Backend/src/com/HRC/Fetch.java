package com.HRC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.HRC.Connect;
import com.HRC.Pojo;

/**
 * Servlet implementation class Fetch
 */
@WebServlet("/Fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 
		  HashMap<Object, Object> Response = new HashMap<Object, Object>();
		  
		  //declaration of all the variables
		  String business_code,clear_date,doc_id,posting_date,document_create_date,
			 due_in_date,invoice_currency,document_type,
			 baseline_create_date,cust_payment_terms,aging_bucket;
		  Float total_open_amount;
		  int sl_no,cust_number,buisness_year,posting_id,invoice_id;
		  
		  ArrayList<Pojo> data = new ArrayList<Pojo>();
		  
		  try {		
				Connection conn = Connect.createConnect();

				String sql_query="SELECT * from winter_internship where is_deleted=0";
				PreparedStatement st=conn.prepareStatement(sql_query);
				ResultSet rs = st.executeQuery();				 
				 	
				 while(rs.next())
				 {
						
						 sl_no=rs.getInt("sl_no");
						 business_code=rs.getString("business_code");
						 cust_number=rs.getInt("cust_number");
						 clear_date=rs.getString("clear_date");
						 buisness_year=rs.getInt("buisness_year");
						 doc_id=rs.getString("doc_id");
						 posting_date=rs.getString("posting_date");
						 document_create_date=rs.getString("document_create_date");
						 due_in_date=rs.getString("due_in_date");
						 invoice_currency=rs.getString("invoice_currency");
						 document_type=rs.getString("document_type");
						 posting_id=rs.getInt("posting_id");
						 total_open_amount=rs.getFloat("total_open_amount");
						 baseline_create_date=rs.getString("baseline_create_date");
						 cust_payment_terms=rs.getString("cust_payment_terms");
						 invoice_id=rs.getInt("invoice_id"); 
						 aging_bucket=rs.getString("aging_bucket");
						 
						 Pojo s = new Pojo();
						 s.setSl_no(sl_no);
						 s.setBusiness_code(business_code);
						 s.setCust_number(cust_number);
						 s.setClear_date(clear_date);
						 s.setBuisness_year(buisness_year);
						 s.setDoc_id(doc_id); 
						 s.setPosting_date(posting_date);
						 s.setDocument_create_date(document_create_date);
						 s.setDue_in_date(due_in_date); 
						 s.setInvoice_currency(invoice_currency);
						 s.setDocument_type(document_type);
						 s.setPosting_id(posting_id);
						 s.setBaseline_create_date(baseline_create_date);
						 s.setCust_payment_terms(cust_payment_terms);
						 s.setInvoice_id(invoice_id);
						 s.setAging_bucket(aging_bucket);
											
						data.add(s);
							
				 }
				 Response.put("invoiceData",data);
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
		  
		
		  //System.out.println(data);
		  	
		  	Gson gson = new Gson();
			String respData = gson.toJson(Response);
			
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("application/json");
			response.getWriter().append(respData);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


