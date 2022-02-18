package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import co.edu.unbosque.vista.Vista;

public class Controller implements ActionListener{
	private Fachada Fachada;
	private Principal gui;
	private String cedula1;
	private String codproducto;
	public Controller() {
		Fachada=new Fachada();
		gui=new Principal();
		gui.setVisible(true);
		
		
		asignaroyentes();
	
	}
	public void asignaroyentes() {
		gui.getBtnClientes().addActionListener(this);
		gui.getBtnNewButton().addActionListener(this);
		gui.getBtnNewButton_1().addActionListener(this);
		gui.getBtnProducto().addActionListener(this);
		gui.getBtnVentas().addActionListener(this);
		gui.getCliente().getBtnNewButton_2().addActionListener(oyenteDeaccioncliente);
		gui.getCliente().getBtnNewButton_1().addActionListener(oyenteDeaccioncliente);
		gui.getCliente().getBtnNewButton().addActionListener(oyenteDeaccioncliente);
		gui.getCliente().getBtnNewButton_3().addActionListener(oyenteDeaccioncliente);
		gui.getForm_cliente().getBtnRegistrarTienda().addActionListener(oyendedecliente2);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("esta pasando por la lenia 30");
		System.out.println("este es el get action command"+e.getActionCommand());
		if(e.getActionCommand().equals(gui.Clientes)) {
			System.out.println("usted espicho a clientes");

			gui.getCliente().setVisible(true);
	
		}
		if(e.getActionCommand().equals(gui.Ventas)) {
			System.out.println("usted espicho ventas");
			gui.getVenta().setVisible(true);
		}
		if(e.getActionCommand().equals(gui.Producto)) {
			System.out.println("usted espicho producto");
			gui.getproducto().setVisible(true);
		}
		if(e.getActionCommand().equals(gui.Pdf)) {
			System.out.println("usted espciho pdf");
			crearpdf generatePDFFileIText = new crearpdf();
			generatePDFFileIText.createPDF(new File("./Data/InformeEmpresa.pdf"));
			
		}
		if (e.getActionCommand().equals(gui.Registro)) {
			System.out.println("usted espicho registro");
			gui.getregistro().setVisible(true);
		}
		
		
	}
	ActionListener oyenteDeaccioncliente=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("se esta escuchando algo de cliente");
			if(e.getActionCommand().equals(gui.getCliente().Actualizar)) {
				System.out.println("usted espicho el actualizar");
				String cedula=JOptionPane.showInputDialog(null, "ingrese la cedula de la persona a actualizar");
				cedula1=cedula;
				if(Fachada.getClientedao().existecliente(cedula)) {
					gui.getFormactualizacioncliente().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "la persona con la cedula ingresada no esta en base de datos");
				}
			}
			if(e.getActionCommand().equals(gui.getCliente().Eliminar)) {
				System.out.println("se espicho eliminar");
				String cedula=JOptionPane.showInputDialog("ingrese la cedula de el cliente que desea eliminar");
				JOptionPane.showMessageDialog(null,Fachada.getClientedao().eliminarcliente(cedula));
			}
			if(e.getActionCommand().equals(gui.getCliente().Registrar)) {
				System.out.println("se espicho registrar");
				gui.getForm_cliente().setVisible(true);
			}
			
		}
		
		
		
	};
	
	ActionListener oyendedecliente2=new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("se espocho el oyente del cliente");
			String cedula=gui.getForm_cliente().getTxtCedula().getText();
			String nombre=gui.getForm_cliente().getTxtNombre().getText();
			String direccion=gui.getForm_cliente().getTxtdireccion().getText();
			String telefono=gui.getForm_cliente().getTxttelefono().getText();
			String correo=gui.getForm_cliente().getTtxtcorreoelectronic().getText();
			if(Fachada.getClientedao().existecliente(cedula)) {
				JOptionPane.showMessageDialog(null, " esa cedula ya existe ingrese otra cedula");
			}else {
			ClienteDTO nuevo_cliente=new ClienteDTO(nombre,cedula,direccion,telefono,correo);
			Fachada.getClientedao().agregarCliente(nuevo_cliente);
			}
		}
		
	};
	
	ActionListener oyendetienda=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		String nombred=gui.getregistro().getTxtNombreEmpresa().getText();
		String tipocomer=gui.getregistro().getTxtTipoComercio().getText();
		String nit=gui.getregistro().getTxtNit().getText();
		String ciudad=gui.getregistro().getTxtCiudad().getText();
		String iva=gui.getregistro().getTxtValorIva().getText();
		String banco=gui.getregistro().getTxtNombreDelBanco().getText();
		String Ncuenta=gui.getregistro().getTxtNumeroCuenta().getText();
		String nombreg=gui.getregistro().getTxtNombreDelGErente().getText();
		
		Fachada.getCP().escribirPropiedades(nombred, tipocomer, nit, ciudad, iva, iva, banco, Ncuenta, nombreg);
		Fachada.getCP().leerproperties();
		}
		
	};
	
	ActionListener oyenteaccionventa=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals(gui.getVenta().Actualizar)) {
				System.out.println("usted espicho actulizar venta");
			}
			if(e.getActionCommand().equals(gui.getVenta().Eliminar)) {
				System.out.println("usted espicho eliminar");
			}
			if(e.getActionCommand().equals(gui.getVenta().Registrar)) {
				gui.getForm_v().setVisible(true);
			}
		}
		
	};
		
	ActionListener oyentedeventaformulario=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals(gui.getForm_v().RegistrarV)) {
				System.out.println("usted espicho registrar venta");
				System.out.println(gui.getForm_v().getTxtcantidad().getText()+" esta es la cantidad");
				System.out.println(gui.getForm_v().getTxtCcliente().getText()+" esta es la cedula del cliente");
				System.out.println(gui.getForm_v().getTxtCodproducto().getText()+" esta es el codigo del porducto");
				System.out.println(gui.getForm_v().getTxtcodventa().getText()+" este es el codigo de la venta");
				int cantidad=Integer.parseInt(gui.getForm_v().getTxtcantidad().getText());
				System.out.println(cantidad+" esta es la cantidad");
				String cedulacliente=gui.getForm_v().getTxtCcliente().getText();
				String codigoproducto=gui.getForm_v().getTxtCodproducto().getText();
				if(Fachada.getClientedao().existecliente(cedulacliente) && Fachada.getProductodao().existeproducto(codigoproducto)) {
					ProductoDTO producto=Fachada.getProductodao().buscarproducto(codigoproducto);
					int codventa=Fachada.getVentasdao().devuelvesize();
					System.out.println(codventa+" este es el codventa");
					double iva=Double.parseDouble(Fachada.getCP().getProperty("IVA"));
					double cantidadpagarsiniva=Fachada.getVentasdao().cantidadsiniva2(cantidad, producto.getPrecioVenta());
					double valortotaliva=Fachada.getVentasdao().totaliva2(cantidad);
					double saldoapagar=Fachada.getVentasdao().saldototal2(cantidad, producto.getPrecioVenta());
					System.out.println(codventa+" este es el codigo venta");
					System.out.println(iva+" esta es la iva");
					System.out.println(cantidadpagarsiniva+" esta es la cantidad a pagar sin iva");
					System.out.println(valortotaliva+" este es el valortotaliva");
					System.out.println(saldoapagar+" este es el saldo a pagar");
					VentaDTO Nuevaventa=new VentaDTO(iva,valortotaliva,saldoapagar,codventa,cedulacliente,cantidadpagarsiniva,cantidad,codigoproducto, false);
					Fachada.getVentasdao().agregarProducto(Nuevaventa);
					JOptionPane.showMessageDialog(null, "este es el nombre del producto: "+producto.getNombreProducto()+"\n"+"saldo total de esta venta: "+saldoapagar+"\n"+"cargado al usuario con cedula: "+cedulacliente+"\n"+"cantidad del producto: "+cantidad);
				}
				
				
			}
			if(e.getActionCommand().equals(gui.getForm_v().Pagar)) {
				System.out.println("usted espicho pagar venta");
				String cedulacliente=JOptionPane.showInputDialog("ingrese la cedula para confirmar pago");
				JOptionPane.showMessageDialog(null,Fachada.getVentasdao().cancelarproductos(cedulacliente));
				
			}
			if(e.getActionCommand().equals(gui.getForm_v().Totalizar)) {
				System.out.println("usted espicho totalizar");
				String cedula=JOptionPane.showInputDialog("ingrese la cedula del cliente que quiere ver deuda");
				JOptionPane.showMessageDialog(null,"su deuda con nosotros es la suma de: "+ Fachada.getVentasdao().devuelvetotaldeuda(cedula));
			}
			
		}
		
	};
	ActionListener oyentedeacciondeporducto=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals(gui.getproducto().Registrarproducto)) {
				System.out.println("usted espicho registro de producto");
				gui.getForm_p().setVisible(true);
			}
			if(e.getActionCommand().equals(gui.getproducto().Eliminarproducto)) {
				System.out.println("usted espicho eliminar producto");
				String codigo=JOptionPane.showInputDialog("ingrese el codigo del producto a eliminar");
				JOptionPane.showMessageDialog(null, Fachada.getProductodao().eliminarproducto(codigo));
			}
			if(e.getActionCommand().equals(gui.getproducto().Actualizarproducto)) {
				System.out.println("usted espicho actualizar");
				String codigo=JOptionPane.showInputDialog("ingrese el codigo del producto que desea actualizar");
				codproducto=codigo;
				if(Fachada.getProductodao().existeproducto(codigo)) {
					
					gui.getFormularioactualizacionporducto().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "producto no encontrado");
				}
			}
		}
		
	};
	ActionListener oyentebotonactualiza=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("usted espicho actualizar producto");
			String codigo=JOptionPane.showInputDialog("ingrese el codigo del producto que desea actualizarle el precio");
			codproducto=codigo;
			if(Fachada.getProductodao().existeproducto(codigo)) {
				int nuevovalor=Integer.parseInt(JOptionPane.showInputDialog("ingrese el nuevo valor para venta"));
				JOptionPane.showMessageDialog(null,Fachada.getProductodao().actualizarproductos(codigo, nuevovalor));
				
			}else {
				JOptionPane.showMessageDialog(null, "producto no encontrado");
			}
		}
		
	};
	ActionListener oyenteregistroproducto= new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals(gui.getForm_p().registroproducto)) {
				System.out.println("usted espicho registro de producto");
				String codproducto=gui.getForm_p().getTxtCodigoDeProducto().getText();
				int preciocompra=Integer.parseInt(gui.getForm_p().getTxtNitDeProveedorDelProducto().getText());
				String nombreproducto= gui.getForm_p().getTxtNombreProducto().getText();
				int precioventa= Integer.parseInt(gui.getForm_p().getTextPrecioVenta().getText());
				int NIT=Integer.parseInt(gui.getForm_p().getTxtPrecioCompra().getText());
				System.out.println(codproducto+" este es el codigo del producto");
				System.out.println(preciocompra+" este es ek preciocompra");
				System.out.println(nombreproducto+" este es el nomrbe del producto");
				System.out.println(precioventa+" este es el precio del producto");
				System.out.println(NIT+" este es el nit ");
				if(Fachada.getProductodao().existeproducto(codproducto)) {
					JOptionPane.showMessageDialog(null, "ese codigo de producto ya existe");
				}else {
				ProductoDTO producto=new ProductoDTO(nombreproducto,codproducto,precioventa,NIT,preciocompra);
				Fachada.getProductodao().agregarProducto(producto);
				JOptionPane.showMessageDialog(null, "creacion de objeto satisfactoria");
				}
			}
		}
		
	};
	ActionListener oyenteactualizarcliente=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("usted espicho oyente de actualizacion de cliente");
			String cedula=cedula1;
			String direccion=(gui.getFormactualizacioncliente().getTxtdireccion().getText());
			String nombre=(gui.getFormactualizacioncliente().getTxtNombre().getText());
			String telefono=(gui.getFormactualizacioncliente().getTxttelefono().getText());
			String correo=(gui.getFormactualizacioncliente().getTtxtcorreoelectronic().getText());
			JOptionPane.showMessageDialog(null, Fachada.getClientedao().actualizacioncliente(cedula, direccion, nombre, correo, telefono));
		}
	};
	ActionListener oyenteactualizarproducto=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("usted espicho registrar actualzion de producto");
			ProductoDTO producto=Fachada.getProductodao().buscarproducto(codproducto);
			producto.setNombreProducto(gui.getFormularioactualizacionporducto().getTxtNombreProducto().getText());
			producto.setNIT(Integer.parseInt(gui.getFormularioactualizacionporducto().getTxtNitDeProveedorDelProducto().getText()));
			producto.setPrecioCompra(Integer.parseInt(gui.getFormularioactualizacionporducto().getTxtPrecioCompra().getText()));
			producto.setPrecioVenta(Integer.parseInt(gui.getFormularioactualizacionporducto().getTextPrecioVenta().getText()));
			JOptionPane.showMessageDialog(null, "Actualizacion de producto sin ningun problema");
			gui.getFormularioactualizacionporducto().setVisible(false);
			
		}
		
	};
	ActionListener oyendederegresoformulariocliente=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getForm_cliente().setVisible(false);
		}
		
	};
	ActionListener oyenteregresoformulariotienda=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getregistro().setVisible(false);
		}
	};
	
	ActionListener oyenteregresoformularioActualizacioncliente=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getFormactualizacioncliente().setVisible(false);
		}
	};
	ActionListener oyenteregresoformularioproducto=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getForm_p().setVisible(false);
		}
	};
	ActionListener oyenteregresoformularioventa=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getForm_v().setVisible(false);
		}
	};
	ActionListener oyenteregresoaccionescliente=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getCliente().setVisible(false);
		}
	};
	
	ActionListener oyenteregresoaccionesproducto=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getproducto().setVisible(false);
		}
	};
	ActionListener oyenteregresoaccionesventa=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getVenta().setVisible(false);
		}
	};
	ActionListener oyenteregresoactualizacionproducto=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getFormularioactualizacionporducto().setVisible(false);
		}
	};
	ActionListener oyenteregresoactualizacionventa=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gui.getForm_v().setVisible(false);
		}
	};