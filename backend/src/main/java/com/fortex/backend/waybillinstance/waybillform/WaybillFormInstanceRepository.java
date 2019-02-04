package com.fortex.backend.waybillinstance.waybillform;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaybillFormInstanceRepository extends JpaRepository<WaybillFormInstance, Long> {

    List<WaybillFormInstance> findAll();

    WaybillFormInstance findWaybillById(Long id);
}
