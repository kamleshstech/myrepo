package com.practice.jpa.amj.entity.runner;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.jpa.amj.entity.BackWordCompatabilityWithHibernateDemo;
import com.practice.jpa.amj.entity.Customer;
import com.practice.jpa.amj.entity.Offer;
import com.practice.jpa.amj.entity.repo.BackWordCompatabilityWHibernateRepo;
import com.practice.jpa.amj.entity.repo.CustomerRepo;
import com.practice.jpa.amj.entity.repo.OfferRepo;

@Component
public class AssociationMappingAndJoinsRunner implements CommandLineRunner{

	@Autowired
	CustomerRepo cRepo;
	
	@Autowired
	OfferRepo oRepo;
	
	@Autowired
	BackWordCompatabilityWHibernateRepo bRepo;
	
	@Override
	public void run(String... args) throws Exception {
//		Offer off1 = new Offer(1, "off-dtls","ariba vendor");
//		Offer off2 = new Offer(2, "off-dtls-acc","Accenture vendor");
//		
//		//oRepo.saveAll(null);
//		
//		Customer joy = new Customer(100, "joy",List.of(off1,off2));
//		cRepo.save(joy);
//		System.out.println("offer mapped with customer......");
//		
//		//************************joins*************************************
//		List<Object[]> customerById = cRepo.getCustomerById(100);
//		for(Object [] ob : customerById) {
//			System.out.println(ob[0]+"-"+ob[1]+"-"+ob[2]);
//		}
		
		//***********************************Hibernate Backword Compatability with JPA******************************
		//**************************working with BLOB and CLOB
		
		FileInputStream fis = new FileInputStream("D:\\VIVIDHA & KAMLESH\\VIVIDHA & KAMLESH\\ENG\\1\\KIS_0058 (Large).JPG");
		byte[] byteArr = new byte[fis.available()];
		
		String input = "ASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDADASDASDASDASDASDASDASDAD";
		char[] charArr = input.toCharArray(); 

		//Date EX 
		Date d = new Date();
		
		BackWordCompatabilityWithHibernateDemo b1 = new BackWordCompatabilityWithHibernateDemo(111, "AAAAAAAAAAAAAAAA", byteArr, charArr,d,d,d);
		
		//BackWordCompatabilityWithHibernateDemo b2 = new BackWordCompatabilityWithHibernateDemo(222, "BBBBBBBBBBBBB");
		//BackWordCompatabilityWithHibernateDemo b3 = new BackWordCompatabilityWithHibernateDemo(333, "CCCCCCCCCCCCCCCCCCCCC");
		
		bRepo.save(b1);	//bRepo.save(b2);bRepo.save(b3);
		
		//***************************getting result*****************
//		List<String> dtls = bRepo.getDtls(111);
//		dtls.forEach(System.out::println);
		

		System.out.println("Date is : "+b1.getDtA()+" - "+b1.getDtB()+" - "+" - "+b1.getDtC()); 
	}
	
}
