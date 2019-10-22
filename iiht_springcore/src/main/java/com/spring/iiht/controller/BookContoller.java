package com.spring.iiht.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.iiht.model.Book;
import com.spring.iiht.service.ApplicationService;

@Controller
public class BookContoller {

	@Autowired
	ApplicationService appService;
	
   @GetMapping("/")
   @PostMapping("/")
   public String welcome() {
      return "index";
   }

    @GetMapping(path = "/book/list")
	public String getAllBooks(Model model) throws Exception {
		System.out.println("Inside Booklist page");
		List<Book> bookList = new ArrayList<Book>();
		bookList = appService.getAllBooks();
		model.addAttribute("books", bookList);
		return "books";
	}
	
	@GetMapping(path = {"/book/search"})
	public String getBooks(@RequestParam(name="title", value ="title", required=false) String title, Model model) throws Exception {
		List<Book> bookList = new ArrayList<Book>();
		System.out.println("title ---"+title);
		
		if(title!= null)
		{
			bookList = appService.findBook(title.toUpperCase());
		}
		else
		{
			bookList = appService.getAllBooks();
		}
		model.addAttribute("books", bookList);
		return "books";
	}
	
	@GetMapping(path = "/book/add-book-form")
	public String showBookForm(Model model) throws Exception {
		Book book = new Book();
		model.addAttribute("book", book);
		return "add-book-form";
	}
	
	@PostMapping(path = "/book/create")
	public String addBook(@ModelAttribute("book") Book newBook) throws Exception {
		appService.addBook(newBook);
		return "redirect:/book/list";
	}
	
	@GetMapping(path = "/book/delete")
	public String deleteBook(@RequestParam Long bookId) throws Exception {
		appService.deleteBook(bookId);
		return "redirect:/book/list";
	}
}
