package com.aiss.f1api;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;
import java.util.Optional;



import com.aiss.f1api.models.RaceModel;

import com.aiss.f1api.repositories.RaceRepository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class RaceRepositoryTest {
    
    @Autowired
    private RaceRepository repo;
    @Test
	@Order(1)
	void testSaveRace() {
		RaceModel Barcelona = new RaceModel("Montmelo", "2002","David","Julio","Messi", "CR7", "Kiki", "ViniJR","Pato","Momo","Isabel Pantoja","Kiko Rivera");
		repo.save(Barcelona);
		assertEquals("Montmelo", Barcelona.getGp());
	}
	@Test
	@Order(2)
	void testSaveRace2() {
		RaceModel Monaco = new RaceModel("Monaco", "2002","David","Julio","Messi", "CR7", "Kiki", "ViniJR","Pato","Momo","Isabel Pantoja","Kiko Rivera");
		repo.save(Monaco);
		assertEquals("David", Monaco.getFirst());
	}
	@Test
	@Order(3)
	void testUpdateRace(){
		RaceModel Mini2 = repo.findById(1L).get();
		Mini2.setSecond("Pepe");;	
		repo.save(Mini2);
		RaceModel MiniUpdated= repo.findById(1L).get();
		assertEquals("Pepe", MiniUpdated.getSecond());
	}
	@Test
	@Order(4)
	void testGetByGranPremio(){
		String gp="Italy";
		List<RaceModel> Mini4 = repo.findByGp(gp);
		assertEquals(16, Mini4.size());
	}
	@Test
	@Order(5)
	void testDeleteRace(){
		RaceModel Mini3= repo.findById(1L).get();
		repo.deleteById(Mini3.getId());
		assertEquals(Optional.empty(), repo.findById(1L));
	}
}
