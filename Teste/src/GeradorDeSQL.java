import java.util.ArrayList;

public class GeradorDeSQL {

	FormadorSQL formador;
	private String data, medico, tipo;
	private String query;

	private ArrayList<Medico> listaMedicos;

	GeradorDeSQL() {

		int[] medicos = { 135, 456, 1, 24, 666, 1 };
		formador = new FormadorSQL();
		listaMedicos = new ArrayList<Medico>();
		populaMedicos();
		this.data = formador.selecionarData("33/33/2015");
		this.tipo = formador.selecionarTipo();
		this.medico = formador.selecionarMedico(medicos);
		geraQuery();
	}

	private void geraQuery() {
		query = "select p.nome, t.TELEFONENUMERICO, p.SEXO, c.DATA, r.NOME\n"
				+ "from CL_ATENDIMENTOS c inner join CL_PACIENTES p on c.PACIENTE = p.handle\n"
				+ "inner join CL_PACIENTETELEFONES t on t.PACIENTE = p.HANDLE\n"
				+ "inner join CL_RECURSOS r on c.RECURSO = r.HANDLE\n" + "where "
				+ data + tipo + medico + "\norder by r.nome, c.data";
	}

	public FormadorSQL getFormadorDeSQL() {
		return formador;
	}

	private void populaMedicos() {
		listaMedicos.add(new Medico("PEDRO", 1));
	}

	public String toString() {
		return query;
	}

}