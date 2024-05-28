package com.app.videogame.controller;

import com.app.videogame.models.entity.Producto;
import com.app.videogame.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/video-game")
@SessionAttributes(value = "cart")
public class VideoGamesPage
{
    @ModelAttribute("cart")
    public List<Producto> cart() {
        return new ArrayList<>();
    }

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/home")
    public String home()
    {
        return "./vistas/videogame";
    }

    @GetMapping(value = "/juegos")
    public String juegos()
    {
        return "./vistas/juegos";
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam Long productId, @ModelAttribute("cart") List<Optional<Producto>> cart) {
        Optional<Producto> product = productService.getProductById(productId);
        if (product != null) {
            cart.add(product);
        }
        return "redirect:/cart/view";
    }

    @GetMapping("/ver")
    public String viewCart(@ModelAttribute("cart") List<Producto> cart, Model model) {
        model.addAttribute("cartItems", cart);
        return "/vistas/carrito";
    }

//    @GetMapping("/cart/remove/{productId}")
//    public String removeFromCart(@PathVariable Long productId, HttpSession session) {
//        // Lógica para eliminar un producto del carrito utilizando el ID del producto
//        List<Long> cart = (List<Long>) session.getAttribute("cart");
//        if (cart != null) {
//            cart.remove(productId);
//        }
//        return "redirect:/video-game/cart/ver";
//    }

}
