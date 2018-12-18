package com.teamtreehouse.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


/**
 * Created by Marius on 2/6/2017.
 */

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {


    @RestResource(rel ="title-contains", path="containsTitle")
    Page<Course> findTop3ByTitleContaining(@Param("title") String title, Pageable pageable);
    Page<Course> findCourseByUrl(@Param("url") String url, Pageable pageable);
}
