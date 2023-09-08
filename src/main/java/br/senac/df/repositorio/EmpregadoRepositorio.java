package br.senac.df.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.senac.df.dto.DeptEmpDto;
import br.senac.df.entidade.Empregado;

public interface EmpregadoRepositorio extends JpaRepository<Empregado, Integer>{

	@Query("SELECT new br.senac.df.dto.DeptEmpDto(d.nome, e.nome, e.email, e.endereco)"
			+ "FROM Departamento d INNER JOIN d.empregado e")
	List<DeptEmpDto> fetchEmpDeptDataInnerJoin();
	
	@Query("SELECT new br.senac.df.dto.DeptEmpDto(d.nome, e.nome, e.email, e.endereco)"
			+ "FROM Departamento d, Empregado e")
	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();
}
