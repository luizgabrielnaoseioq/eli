package com.senai.eli.Repository;

import com.senai.eli.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Event, Long> {

}
