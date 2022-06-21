/*Creado por Gina Gaggero Schivo 
*/
package cl.crud.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.crud.models.entity.TipoVehiculo;
import cl.crud.models.entity.Vehiculo;
import cl.crud.models.service.ITipoVehiculoService;
import cl.crud.models.service.IVehiculoService;
//import cl.crud.util.paginator.PageRender;

@Controller
@SessionAttributes("vehiculo")
public class NaveController {
	
	@Autowired
	private IVehiculoService vehiculoService; 
	
	@Autowired
	private ITipoVehiculoService tipoVehiculoService;

	
	//PAGINA DE INICIO
	@GetMapping("/")
	public String home() {
		return "home";
	}

	//LISTAR TODAS LAS NAVES
	
	/*//LISTADO CON PAGINADO
	 * @RequestMapping(value = "/listar", method = RequestMethod.GET) public String
	 * listar(@RequestParam(name = "page", defaultValue = "0") int page, String nombreVehiculo, String CBoCA, String IdentificacionVehiculo, Model model) {
	 * 
	 * Pageable pageRequest = new PageRequest(page, 10);
	 * 
	 * Page<Vehiculo> vehiculos = vehiculoService.findAll(pageRequest);
	 * 
	 * PageRender<Vehiculo> pageRender = new PageRender<Vehiculo>("/listar", vehiculos); 
	 * model.addAttribute("vehiculos", vehiculos);
	 * model.addAttribute("page", pageRender); 
	 * return "buscar"; 
	 * }
	 */
	 
	
	//LISTADO Y FILTRO DE NAVES POR NOMBRE-CBOCA-MATRICULA
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model,String nombreVehiculo, String CBoCA, String IdentificacionVehiculo) {
		
		Iterable<Vehiculo> vehiculos = vehiculoService.buscar(nombreVehiculo, CBoCA, IdentificacionVehiculo);
		
		model.addAttribute("vehiculos", vehiculos);	
		model.addAttribute("nombreVehiculo", nombreVehiculo);
		model.addAttribute("CBoCA", CBoCA);
		model.addAttribute("IdentificacionVehiculo", IdentificacionVehiculo);

		return "buscar";
	}

	
	//PAGINA NUEVO
	//CREA NAVE NUEVA
	@RequestMapping(value = "/nuevo")
	public String crear(Map<String, Object> model) {
		
		List<TipoVehiculo> listaTipoNaves = tipoVehiculoService.getNaves();
		model.put("listaTipoNaves", listaTipoNaves);
		
		Vehiculo vehiculo = new Vehiculo();
		model.put("vehiculo", vehiculo);	
		model.put("titulo", "Crear nave nueva");
		return "/nuevo";
	}
	
	//GUARDA NAVE
	@RequestMapping(value="/guardar", method = RequestMethod.POST)   
	public String guardar(@Valid Vehiculo vehiculo, BindingResult result, Map<String, Object> model, RedirectAttributes flash, SessionStatus status) {
	   
		//SI DEJA EN BLANCO CAMPOS REQUERIDOS VUELVE A CARGAR EL FORMULARIO   
		if (result.hasErrors()) {
			List<TipoVehiculo> listaTipoNaves = tipoVehiculoService.getNaves();
			model.put("listaTipoNaves", listaTipoNaves);
            return "nuevo";
        }

		String mensajeFlash = (vehiculo.getIdVehiculo() != null) ? "Nave modificada!" : "Nave creada!";

		String nombreVehiculo = vehiculo.getNombreVehiculo();
		String CBoCA = vehiculo.getCBoCA();
		String IdentificacionVehiculo = vehiculo.getIdentificacionVehiculo(); // matricula
		
		Iterable<Vehiculo> vehiculos  = vehiculoService.buscar(nombreVehiculo, CBoCA, IdentificacionVehiculo);
		
		if (vehiculos != null) { // TODO  && vehiculos[0] !=null
			String mensaje = "Ya existe una nave con esos datos, por favor verifique los datos ingresados";
			model.put("mensajeError", mensaje);
			List<TipoVehiculo> listaTipoNaves = tipoVehiculoService.getNaves();
			model.put("listaTipoNaves", listaTipoNaves);
			
			return "nuevo";
			
		}
		else {
			vehiculoService.save(vehiculo);
		}
		
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/listar";	
	}
	
	//VISUALIZA UNA NAVE
	@GetMapping(value = "/visualizar/{idVehiculo}")
	public String ver(@PathVariable(value = "idVehiculo") Long idVehiculo, Map<String, Object> model, RedirectAttributes flash) {
		
		Vehiculo vehiculo = vehiculoService.findOne(idVehiculo);
		if (vehiculo == null) {
			flash.addFlashAttribute("error", "La nave no existe en la base de datos");
			return "redirect:/listar";
		}

		List<TipoVehiculo> listaTipoNaves = tipoVehiculoService.getNaves();
		model.put("listaTipoNaves", listaTipoNaves);
		model.put("vehiculo", vehiculo);
		return "visualizar";
	}

	//ELIMINA UNA NAVE
	@RequestMapping(value = "/eliminar/{idVehiculo}")
	public String eliminar(@PathVariable(value = "idVehiculo") Long idVehiculo, RedirectAttributes flash) {

		if (idVehiculo > 0) {
			vehiculoService.delete(idVehiculo);
			flash.addFlashAttribute("success", "Nave eliminada con exito!");
		}
		return "redirect:/listar";
	}

	//MODIFICAR
	//PAGINA MODIFICAR
		@RequestMapping(value = "/modificar")
		 public String modificar(Map<String, Object> model) {
			 return "modificar";
		 } 
		
		//MODIFICA UNA NAVE
			@RequestMapping(value = "/modificar/{idVehiculo}")
			public String editar2(@PathVariable(value = "idVehiculo") Long idVehiculo, Map<String, Object> model, RedirectAttributes flash) {

				Vehiculo vehiculo = null;

				if (idVehiculo > 0) {
					vehiculo = vehiculoService.findOne(idVehiculo);
					
					if (vehiculo == null) {
						return "redirect:/listar";
					}
				} else {
					return "redirect:/listar";
				}
				List<TipoVehiculo> listaTipoNaves = tipoVehiculoService.getNaves();
				model.put("listaTipoNaves", listaTipoNaves);
				model.put("vehiculo", vehiculo);
				model.put("editar", "Editar nave");
				return "modificar";

			}
		
		//GUARDA NAVE MODIFICADA
		@RequestMapping(value="/modificar", method = RequestMethod.POST)   
		public String modificar(@Valid Vehiculo vehiculo, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		       
			if (result.hasErrors()) {
	            return "nuevo";
	        }
	        
			vehiculoService.save(vehiculo);
			status.setComplete();
			return "redirect:/listar";	
		}
	
		

}
