package com.kltn.api.serviceImlp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kltn.api.dao.LopHocRepository;
import com.kltn.api.dao.NganhRepository;
import com.kltn.api.entity.LopHoc;
import com.kltn.api.entity.NganhHoc;
import com.kltn.api.service.LopHocService;

@Service
@Transactional
public class LopHocServiceImlp implements LopHocService{

	@Autowired
	private LopHocRepository lopHocRepository;
	@Autowired
	private NganhRepository nganhRepository;
	
	@Override
	public void saveOrUpdateLopHoc(LopHoc lopHoc) {
		if(!lopHoc.getNganhHoc().getMaNganh().equals("")) {
			var nganh = nganhRepository.findById(lopHoc.getNganhHoc().getMaNganh()).get();
			if(nganh != null) {
				lopHoc.setNganhHoc(nganh);
			}
			else {
				nganh = new NganhHoc(lopHoc.getNganhHoc().getMaNganh());
			}
			
		}
		lopHocRepository.save(lopHoc);
	}

	@Override
	public List<LopHoc> getAllLopHoc() {
		// TODO Auto-generated method stub
		return lopHocRepository.findAll();
	}

	@Override
	public LopHoc getLopHocById(String id) {
		// TODO Auto-generated method stub
		return lopHocRepository.getById(id);
	}

	@Override
	public String autoId() {
		 int id = lopHocRepository.autoId();
		    String naturalId = "LH" + String.format("%03d", id+1);
		    return naturalId;
	}

}