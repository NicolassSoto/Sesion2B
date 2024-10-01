package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;

class EmpleadoTest {
	Empleado emp ;
	
	Empleado.TipoEmpleado tipo;
	float horasExtras;
	float ventas;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		emp = new Empleado();
		tipo = Empleado.TipoEmpleado.Vendedor;
		horasExtras = 0;
		ventas = 0;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBrutaVendedor() {
		float expected = 2000f;
		
		float actual = emp.calculoNominaBruta(tipo, ventas, horasExtras);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaEncargado() {
		float expected = 2500f;
		tipo = Empleado.TipoEmpleado.Encargado;
		float actual = emp.calculoNominaBruta(tipo, ventas, horasExtras);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVenta1500() {
		float expected = 2200f;
		ventas = 1500;
		float actual = emp.calculoNominaBruta(tipo, ventas, horasExtras);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVenta1000() {
		float expected = 2100f;
		ventas = 1000;
		float actual = emp.calculoNominaBruta(tipo, ventas, horasExtras);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVentaMenos1000() {
		float expected = 2000f;
		ventas = 999;
		float actual = emp.calculoNominaBruta(tipo, ventas, horasExtras);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaHorasExtra() {
		float expected = 2090f;
		horasExtras = 3;
		float actual = emp.calculoNominaBruta(tipo, ventas, horasExtras);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaSinHorasExtra() {
		float expected = 2000f;
		float actual = emp.calculoNominaBruta(tipo, ventas, horasExtras);
		
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNetaSinRetencion() {
		float expected = 2000f;
		float actual = emp.calculoNominaNeta(emp.calculoNominaBruta(tipo, ventas, horasExtras));
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaRetencion15() {
		float expected = 1802f;
		horasExtras = 4;
		float actual = emp.calculoNominaNeta(emp.calculoNominaBruta(tipo, ventas, horasExtras));
		
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaNetaRetencion18() {
		float expected = 2074.6f;
		horasExtras = 1;
		tipo = Empleado.TipoEmpleado.Encargado;
		float actual = emp.calculoNominaNeta(emp.calculoNominaBruta(tipo, ventas, horasExtras));
		
		assertEquals(expected, actual);
	}
}
