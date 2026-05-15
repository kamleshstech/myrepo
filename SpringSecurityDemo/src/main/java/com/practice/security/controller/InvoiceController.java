package com.practice.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.security.model.Invoice;
import com.practice.security.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	//1.create invoice
	@PostMapping("/createInvoice")
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
		Invoice createdInvoice = invoiceService.createInvoice(invoice);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
	}
	//2.update invoice
	@PutMapping("/updateInv")
	public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice){
		Invoice updatedInvoice = invoiceService.updateInvoice(invoice);
		System.out.println(invoice);
		return ResponseEntity.status(HttpStatus.OK).body(updatedInvoice);
	}
	//3.get invoice details
	@GetMapping("/allInv")
	public ResponseEntity<List<Invoice>> getAllInvoices(){
		List<Invoice> allInvoices = invoiceService.getAllInvoices(); 
		return ResponseEntity.status(HttpStatus.OK).body(allInvoices);
	}
	//4.delete invoice
	@DeleteMapping("/deleteInv/{invNum}")
	public ResponseEntity<String> deleteInvoice(@PathVariable("invNum") String invNum){
		String deleteInvoice = invoiceService.deleteInvoice(invNum);
		return ResponseEntity.status(HttpStatus.OK).body(deleteInvoice);
	}

}