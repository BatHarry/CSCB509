package com.sewingfactory.handlers;

public abstract class Handler<T> {
    protected abstract boolean handle(T entity);
}
