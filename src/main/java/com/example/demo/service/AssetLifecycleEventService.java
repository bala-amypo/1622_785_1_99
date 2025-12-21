package com.example.demo.service;
import com.example.demo.entity.AssetLifecycleEvententity;
import java.util.List;

public interface AssetLifecycleEventService {

    AssetLifecycleEvententity saveEvent(AssetLifecycleEvententity event);

    List<AssetLifecycleEvententity> getAllEvents();
}
