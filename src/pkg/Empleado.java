package pkg;

public class Empleado {
	enum TipoEmpleado{Vendedor, Encargado}
	float salario = 0;
	float prima = 0;
	float horasExtra = 0;
	
	float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		
		//Tipo de Empleado
		if(tipo==TipoEmpleado.Vendedor) {
			salario = 2000;
		}else if(tipo==TipoEmpleado.Encargado){
			salario = 2500;
		}
		
		//Tipo de ventas
		if(ventasMes >= 1500) {
			prima = 200;
		}else if(ventasMes>=1000) {
			prima = 100;
		}
		
		
		return salario + prima + horasExtra*30;
		
		
	}
	
	 float calculoNominaNeta(float nominaBruta) {
	
		 float retencion = 0;
		 
		 if(nominaBruta > 2500) {
			 
			 retencion = 0.18f;
			 
		 }else if(nominaBruta >2100) {
			 retencion = 0.15f;
		 }
		 
		 
		 return nominaBruta * (1-retencion);
	}
}
