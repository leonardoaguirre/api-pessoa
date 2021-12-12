package com.br.digitalinovatioone.PessoasAPI.repositories;

import com.br.digitalinovatioone.PessoasAPI.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class PessoaReporitorio implements JpaRepository<Pessoa, Long> {
}
