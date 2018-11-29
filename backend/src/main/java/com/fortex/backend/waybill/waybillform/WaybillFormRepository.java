package com.fortex.backend.waybill.waybillform;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaybillFormRepository extends JpaRepository<WaybillForm, Long> {

    List<WaybillForm> findAll();

    WaybillForm findWaybillFormById(Long id);
}
