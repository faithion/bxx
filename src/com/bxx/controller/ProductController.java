package com.bxx.controller;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bxx.bean.Comment;
import com.bxx.bean.Product;
import com.bxx.bean.Sharing;
import com.bxx.bean.Specification;
import com.bxx.dao.CommentDao;
import com.bxx.dao.OderformDao;
import com.bxx.dao.ProductDao;
import com.bxx.dao.SharingDao;
import com.bxx.service.ProductService;

@Controller
public class ProductController {

	// 注入service对象
	@Resource
	public ProductService productService;
	@Autowired
	public ProductDao productDao;
	@Resource
	public OderformDao oderformDao;
	@Autowired
	private CommentDao commentdao;
	@Autowired
	private SharingDao sharingdao;

	/**
	 * 查询所有数据
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		// 查询数据
		List<Product> list = productService.selectProducts();
		model.addAttribute("list", list);
		return "classify";
	}

	@RequestMapping("/pro")
	public String pro(int id,Model model) {
		String name=productService.selectName(id);
		model.addAttribute("name", name);// 显示商品名称
		model.addAttribute("id", id);// 显示id

		String photo = productService.selectPhoto(id);
		model.addAttribute("photo", photo);// 显示图片

		double price = productService.selectPrice(id);// 显示价格
		model.addAttribute("price", price);

		int sales = productService.addSales(id);// 显示销量
		model.addAttribute("sales", sales);

		int inventory = productService.selectInventory(id);// 显示库存
		model.addAttribute("inventory", inventory);

		// 显示评论
		List<Comment> com = productDao.selectById(id).getComments();
		List<Comment> comments = new LinkedList<>();
		for (Comment comment : com) {
			comments.add(commentdao.selectById(comment.getId()));
		}
		model.addAttribute("comments", comments);
		int pnum = comments.size();
		model.addAttribute("pnum", pnum);

		// 显示拼单人
		List<Sharing> shar = productDao.selectById(id).getSharings();
		List<Sharing> sharings = new LinkedList<>();
		for (Sharing sharing : shar) {
			Sharing s = sharingdao.selectById(sharing.getId());
			sharings.add(s);
		}
		model.addAttribute("sharings", sharings);
		int people = sharings.size();
		model.addAttribute("people", people);

		// 详情属性
		Specification specification = productDao.selectById(id).getSpecification();
		model.addAttribute("specification", specification);
		return "product";
	}

}
