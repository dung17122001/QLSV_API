package com.kltn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kltn.api.entity.ChiTietPhieuDangKy;
import com.kltn.api.entity.PhieuDangKyHocPhan;
import com.kltn.api.service.PhieuDKHPService;

@RestController
@RequestMapping("/api/phieudkhp")
@CrossOrigin(origins =   "${client.url}")
public class PhieuDKHPRest {
	
	@Autowired
	private PhieuDKHPService phieuDKHPService;
	@Autowired
	
	
	@GetMapping
	public List<PhieuDangKyHocPhan> getAllPhieuDKHP() {
		// TODO Auto-generated method stub
		return phieuDKHPService.getAllPhieuDKHP();
	}

	@GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PhieuDangKyHocPhan getPhieuDKHPById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return phieuDKHPService.getPhieuDKHPById(id);
	}

	@PostMapping
	public PhieuDangKyHocPhan addPhieuDK(@RequestBody PhieuDangKyHocPhan phieuDangKyHocPhan) {
		phieuDangKyHocPhan.setMaPhieuDangKy(phieuDKHPService.autoId());
		phieuDKHPService.addOrUpdatePhieuDK(phieuDangKyHocPhan);
		return phieuDangKyHocPhan;
	}
	
	@PutMapping
	public void updatePhieuDK(@RequestBody PhieuDangKyHocPhan phieuDangKyHocPhan) {
		phieuDangKyHocPhan.setMaPhieuDangKy(phieuDKHPService.autoId());
		phieuDKHPService.addOrUpdatePhieuDK(phieuDangKyHocPhan);
	}
	
	@PostMapping("/add-ctpdk")
	public ChiTietPhieuDangKy addChiTietPhieuDK(@RequestBody ChiTietPhieuDangKy chiTietPhieuDangKy) {
		
		phieuDKHPService.addChiTietPhieuDKHP(chiTietPhieuDangKy);
		return chiTietPhieuDangKy;
	}
	  @GetMapping("/hocky-sinhvien")
	    public List<PhieuDangKyHocPhan> findByMaHocKyAndIdSinhVien(@RequestParam String maHocKy, @RequestParam String maSinhVien) {
	        return phieuDKHPService.findByMaHocKyAndIdSinhVien(maHocKy, maSinhVien);
	    }
	  
		@GetMapping("/chitietpdk")
		public List<ChiTietPhieuDangKy> getAllChiTietPDK() {
			// TODO Auto-generated method stub
			return phieuDKHPService.getAllChiTietPhieuDKHP();
		}
		
		@GetMapping("/chitietpdk/byhocky")
		public List<ChiTietPhieuDangKy> findByMaHocKy(String maHocKy) {
			// TODO Auto-generated method stub
			return phieuDKHPService.findByMaHocKy(maHocKy);
		}
}
