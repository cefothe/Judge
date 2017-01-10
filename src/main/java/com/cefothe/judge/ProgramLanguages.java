package com.cefothe.judge;

import  com.cefothe.judge.compilers.Compiler;
import com.cefothe.judge.compilers.JavaCompiler;
import com.cefothe.judge.executors.Executor;
import com.cefothe.judge.executors.JavaExecutor;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by cefothe on 10.01.17.
 */
public enum ProgramLanguages {

    JAVA(JavaCompiler.class, JavaExecutor.class);

    private static final Logger LOG = Logger.getLogger(ProgramLanguages.class);

    Class<? extends Compiler> compiler;
    Class<? extends Executor> executor;

    ProgramLanguages(Class<? extends Compiler> compiler,Class<? extends Executor> executor){
        this.compiler = compiler;
        this.executor = executor;
    }

    public Compiler compiler() {
        try {
            Constructor<? extends Compiler> constructor = compiler.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            LOG.warn("Problem with construct COMPILER ", e);
        }
        return null;
    }

    public Executor executor(){
        try{
            Constructor<? extends  Executor> constructor = executor.getConstructor();
            return constructor.newInstance();
        }catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            LOG.warn("Problem with construct EXECUTOR ", e);
        }
        return null;
    }
}
