package com.practice.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.security.model.Invoice;
import com.practice.security.repo.InvoiceRepo;

@Service
public class InvoiceService {

	@Autowired
	InvoiceRepo invRepo;
	
	//1.create invoice
	public Invoice createInvoice(Invoice invoice) {
		Invoice createdInvoice = null;
		
		if(invoice!=null) {
			createdInvoice = invRepo.save(invoice);
		}
		
		return createdInvoice;
	} 
	
	//2.update invoice
	public Invoice updateInvoice(Invoice invoice) {
		Invoice updatedInvoice = null;
		if(invoice!=null) {
			String invNum = invoice.getInvNum();
			if(invoice.getId()!=null) {
				if(invNum!=null && invNum.length()!=0) { 
					System.out.println("svc"+invoice);
					Invoice invObj = invRepo.findById(invoice.getId()).get();
					invObj.setDetails(invoice.getDetails());
					invObj.setTotalCost(invoice.getTotalCost());
					
					updatedInvoice = invRepo.save(invObj);
				}
			}
		}

		return updatedInvoice;
	} 
	
	
	//3.get invoice details
	public List<Invoice> getAllInvoices(){
		return invRepo.findAll();
	}
	
	//4.delete invoice
	public String deleteInvoice(String invNum) {
		if(invNum!=null) {
			System.out.println("invNum :::::"+invNum);
			Invoice findByInvNum = invRepo.findByInvNum(invNum);
			System.out.println("findByInvNum :::::"+findByInvNum);
			if(findByInvNum !=null) {
			invRepo.delete(findByInvNum);
			}
		}
		return "Invoice is cleared...!!";
	}
}

