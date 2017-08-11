package com.santagar.hotel.dao.jpa;

import com.santagar.hotel.domain.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * HotelRepository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {
    Hotel findHotelByCity(String city);
    Page findAll(Pageable pageable);
}
