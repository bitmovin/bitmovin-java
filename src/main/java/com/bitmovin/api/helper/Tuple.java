package com.bitmovin.api.helper;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 18.08.16.
 */
public class Tuple<T1, T2>
{
    public final T1 t1;
    public final T2 t2;

    public Tuple(T1 t1, T2 t2)
    {
        this.t1 = t1;
        this.t2 = t2;
    }
}
