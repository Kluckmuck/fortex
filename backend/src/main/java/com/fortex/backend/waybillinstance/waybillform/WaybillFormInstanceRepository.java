package com.fortex.backend.waybillinstance.waybillform;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaybillFormInstanceRepository extends JpaRepository<WaybillForm, Long> {

    List<WaybillForm> findAll();

    WaybillForm findWaybillFormById(Long id);
}
