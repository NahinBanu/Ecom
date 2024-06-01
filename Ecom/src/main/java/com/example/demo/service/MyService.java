package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.Items;
import com.example.demo.model.MyModel;
import com.example.demo.repository.Itemrepo;
import com.example.demo.repository.MyRepository;

@Component
public class MyService {

	@Autowired
	private MyRepository repo;
	
	@Autowired 
	private Itemrepo iRepo;
	
	public void save(MyModel model) {
		repo.save(model);	
	}
	public void saveItem(Items item) {
		System.out.println("Data Saved in Service");
		iRepo.save(item);
	}
	public MyModel login(String name, String password) {
		MyModel findByName = repo.findByName(name,password);
		System.out.println(findByName);
		return findByName;		
	}
	public List<Items> fetchItem() {
		List<Items> findAll=iRepo.findAll();
		return findAll;
	}
	public void addItem(int id, MyModel model) {
		Items item =iRepo.findById(id).orElse(null);
		MyModel model1 = repo.findById(model.getId()).orElse(null);	
		model1.getItem().add(item);
		repo.save(model1);
	}
	public MyModel fetchall(MyModel model) {
		MyModel model1 = repo.findById(model.getId()).orElse(null);	
		return model1;
	}	
}
