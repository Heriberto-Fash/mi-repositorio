package net.itinajero.app.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.itinajero.app.model.Pelicula;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = getLista();
//		peliculas.add("Rapidos y Furiosos");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		model.addAttribute("peliculas", peliculas);
		
		return "home";
	}
	
	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapidos y furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		
		return "detalle";
	}
	
	
	//Metodo para generar una lista de objetos de modelo (Pelicula)
	private List<Pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
		
		try {
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("power rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
			//imagen = "cinema.png"
			//estatus = Activa
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("la bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
			
			//agregamos los objetos pelicula a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			
			return lista;
			
		}catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	
}


















