package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController  extends BaseController{
	
	@Resource
	private IAddressService addressService;

	@RequestMapping("/showAddress.do")
	public String showAddress(){
		return "addressAdmin";
	}
	
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(HttpSession session,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag
			){
		ResponseResult<Void> rr=new ResponseResult<Void>(1,"成功");
		Address ad=new Address();
		ad.setUid(this.getId(session));
		ad.setRecvName(recvName);
		ad.setRecvProvince(recvProvince);
		ad.setRecvCity(recvCity);
		ad.setRecvArea(recvArea);
		ad.setRecvAddress(recvAddress);
		ad.setRecvPhone(recvPhone);
		ad.setRecvTel(recvTel);
		ad.setRecvZip(recvZip);
		ad.setRecvTag(recvTag);
		
		addressService.addAddress(ad);
		
		return rr;
		
	}
	@RequestMapping("/getByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getByUid(HttpSession session){
		ResponseResult<List<Address>> rr=null;
		List<Address> list=addressService.getByUid(this.getId(session));
		rr=new ResponseResult<List<Address>>(1,"成功",list);
		return rr;
	}
	//完成异步请求,完成默认收货地址
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session,Integer id){
		ResponseResult<Void> rr=null;
		try{
			addressService.setDefault(this.getId(session), id);
			rr=new ResponseResult<Void>(1,"设置成功");
		}catch(RuntimeException e){
			rr=new ResponseResult<Void>(0,"设置失败");
		}
		return rr;
	}
	@RequestMapping("/goupdate.do")
	@ResponseBody
	public ResponseResult<Address> goupdate(Integer id){
		ResponseResult<Address> rr=null;
		Address address=addressService.getById(id);
		rr=new ResponseResult<Address>(1,"返回成功",address);
		return rr;
	}
	//异步请求,修改收货人地址
	@RequestMapping("/updataAddress.do")
	@ResponseBody
	public ResponseResult<Void> updataAddress(Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag){
		ResponseResult<Void> rr=new ResponseResult<Void>(1,"成功");
		Address ad=new Address();
		ad.setId(id);
		ad.setRecvName(recvName);
		ad.setRecvProvince(recvProvince);
		ad.setRecvCity(recvCity);
		ad.setRecvArea(recvArea);
		ad.setRecvAddress(recvAddress);
		ad.setRecvPhone(recvPhone);
		ad.setRecvTel(recvTel);
		ad.setRecvZip(recvZip);
		ad.setRecvTag(recvTag);
		addressService.updateAddress(ad);
		return rr;
		
	}
	//异步删除收货人地址
	@RequestMapping("/removeAddress.do")
	@ResponseBody
	public ResponseResult<Void> removeAddress(Integer id){
		ResponseResult<Void> rr=null;
		addressService.removeAddress(id);
			rr=new 	ResponseResult<Void>(1,"删除成功");
		return rr;
		
	}
	
	
}
