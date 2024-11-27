package com.banckend1.ReservaTurnos.service.impl;

import com.banckend1.ReservaTurnos.entity.Domicilio;
import com.banckend1.ReservaTurnos.repository.IDomicilioRepository;
import com.banckend1.ReservaTurnos.service.IDomicilioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplDomicilioService implements IDomicilioService {

  public final IDomicilioRepository domicilioRepository;

  public ImplDomicilioService(IDomicilioRepository domicilioRepository) {
    this.domicilioRepository = domicilioRepository;
  }

  @Override
  public Domicilio insertDomicilio(Domicilio domicilio) { return domicilioRepository.save(domicilio); }

  @Override
  public Domicilio selectDomicilio(Long id) { return domicilioRepository.findById(id).orElse(null); }

  @Override
  public List<Domicilio> selectAll() { return domicilioRepository.findAll(); }

  @Override
  public void updateDomicilio(Domicilio domicilio) { domicilioRepository.save(domicilio); }

  @Override
  public void deleteDomicilio(Long id) { domicilioRepository.deleteById(id); }
}