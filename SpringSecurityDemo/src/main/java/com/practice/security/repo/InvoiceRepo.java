package com.practice.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.security.model.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Integer>{

	@Query("SELECT inv FROM Invoice inv WHERE inv.invNum=:invNum")
	Invoice findByInvNum(@Param("invNum") String invNum);
}
