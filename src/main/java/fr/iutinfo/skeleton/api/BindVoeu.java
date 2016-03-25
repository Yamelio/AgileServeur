package fr.iutinfo.skeleton.api;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.skife.jdbi.v2.SQLStatement;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;

@BindingAnnotation(BindVoeu.VoeuBinderFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindVoeu
{ 

  public static class VoeuBinderFactory implements BinderFactory
  {
    public Binder build(Annotation annotation)
    {
      return new Binder<BindVoeu, Voeu>()
      {
        public void bind(SQLStatement q, BindVoeu bind, Voeu arg)
        {
          q.bind("feno", arg.getFormaEtabl().getFeno());
        }
      };
    }
  }
}