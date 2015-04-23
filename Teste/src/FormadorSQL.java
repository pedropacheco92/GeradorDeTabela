public class FormadorSQL {

	private final String tipoTelefone = "3";

	FormadorSQL() {

	}

	public String selecionarMedico(int[] medicos) {
		String s = "";
		for (int i : medicos) {
			s = s + i + ", ";
		}
		return "r.HANDLE in (" + s.substring(0, (s.length() - 2)) + ") ";
	}

	public String selecionarData(String data) {
		// 2015-04-22
		// 22/04/2015
		String dia, mes, ano, proximoDia;
		dia = data.substring(0, 2);
		mes = data.substring(3, 5);
		ano = data.substring(6, 10);

		int intDia = Integer.parseInt(dia);
		proximoDia = (intDia + 1) + "";

		return "c.DATA > '" + ano + "-" + mes + "-" + dia + "' AND c.DATA < '"
				+ ano + "-" + mes + "-" + proximoDia + "' ";
	}

	public String selecionarTipo() {
		return "AND t.TIPO = " + tipoTelefone + " ";
	}

}