package com.milleddy.movucsal.exceptions;

import javassist.NotFoundException;

public class CaminhoNaoEncontradoException extends NotFoundException {
    public CaminhoNaoEncontradoException(String msg) {
        super(msg);
    }

    public CaminhoNaoEncontradoException(String msg, Exception e) {
        super(msg, e);
    }
}
