package com.kltn.api.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
@IdClass(ChiTietPhieuDangKyPK.class)
public class ChiTietPhieuDangKy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "maHocPhan")
	private HocPhan hocPhan;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maPhieuDangKyHP")
	private PhieuDangKyHocPhan phieuDangKyHocPhan;
	
	private Date ngayDangKy;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maLoaiDangKyHP")
	private LoaiDangKyHP loaiDangKyHP;
}
