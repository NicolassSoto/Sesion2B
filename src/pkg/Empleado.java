package pkg;

public class Empleado {
	public enum TipoEmpleado{Vendedor, Encargado}
	public float salario = 0;
	public float prima = 0;
	public float horasExtra = 0;
	
	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		
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
		
		//Horas extras
		if(horasExtra>0) {
			return salario + prima + horasExtra*30;
		}else {
			return salario + prima;
		}
		
		
		
		
	}
	
	 public float calculoNominaNeta(float nominaBruta) {
	
		 float retencion = 0;
		 
		 if(nominaBruta > 2500) {
			 
			 retencion = 0.18f;
			 
		 }else if(nominaBruta >2100) {
			 retencion = 0.15f;
		 }
		 
		 
		 return nominaBruta * (1-retencion);
	}
}
