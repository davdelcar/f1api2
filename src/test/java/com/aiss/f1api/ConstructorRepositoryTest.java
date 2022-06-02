package com.aiss.f1api;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;
import java.util.Optional;


import com.aiss.f1api.models.ConstructorModel;
import com.aiss.f1api.repositories.ConstructorRepository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class ConstructorRepositoryTest {    

    @Autowired
    private ConstructorRepository repo;
    @Test
	@Order(1)
	void testSaveConstructor() {
		ConstructorModel Mini = new ConstructorModel(2L,"Mini", 69, 2080);
		repo.save(Mini);
		assertEquals("Mini", Mini.getTeam());
	}
	@Test
	@Order(2)
	void testSaveConstructor2() {
		ConstructorModel Citroen = new ConstructorModel(3L,"Citroen", 69, 2080);
		repo.save(Citroen);
		assertEquals(2080, Citroen.getYear());
	}
	@Test
	@Order(3)
	void testUpdateConstructor(){
		ConstructorModel Mini2 = repo.findById(1L).get();
		Mini2.setPts(190);	
		repo.save(Mini2);
		ConstructorModel MiniUpdated= repo.findById(1L).get();
		assertEquals(190, MiniUpdated.getPts());
	}
	@Test
	@Order(4)
	void testGetByYear(){
		Integer year=1990;
		List<ConstructorModel> Mini4 = repo.findByYear(year);
		assertEquals(10, Mini4.size());
	}
	@Test
	@Order(5)
	void testDeleteConstructor(){
		ConstructorModel Mini3= repo.findById(1L).get();
		repo.deleteById(Mini3.getId());
		assertEquals(Optional.empty(), repo.findById(1L));
	}}
	