package com.client_ui.client_ui.controller;

import com.client_ui.client_ui.beans.ProductBean;
import com.client_ui.client_ui.proxies.MicroserviceProduitsProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {
    private final MicroserviceProduitsProxy produitsProxy;

    public ClientController(MicroserviceProduitsProxy produitsProxy){
        this.produitsProxy = produitsProxy;
    }

    //affiche tous les produits
    @RequestMapping("/")
    public String accueil(Model model){
        List<ProductBean> produits =  produitsProxy.listeDesProduits();
        model.addAttribute("produits", produits);
        return "Accueil";
    }

    //affiche détaile d'un produit
    @RequestMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id, Model model){
        ProductBean produit = produitsProxy.recupererUnProduit(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }
}