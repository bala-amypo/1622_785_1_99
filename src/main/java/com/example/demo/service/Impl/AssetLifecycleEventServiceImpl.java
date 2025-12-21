package com.example.demo.service.Impl;
import com.example.demo.entity.AssetLifecycleEvententity;
import com.example.demo.repository.AssetLifecycleEventRepository;
import com.example.demo.service.AssetLifecycleEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetLifecycleEventServiceImpl implements AssetLifecycleEventService {

    @Autowired
    private AssetLifecycleEventRepository eventRepository;

    @Override
    public AssetLifecycleEvententity saveEvent(AssetLifecycleEvententity event) {
        return eventRepository.save(event);
    }

    @Override
    public List<AssetLifecycleEvententity> getAllEvents() {
        return eventRepository.findAll();
    }
}
