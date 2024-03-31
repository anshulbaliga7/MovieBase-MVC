package com.anshulbaliga.MovieBase.mappers;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface Mapper<A, B> {
    B mapTo(A a);
    A mapFrom(B b);

    List<B> mapTo(List<A> a);

    List<A> mapFrom(List<B> b);
}
