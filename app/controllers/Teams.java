package controllers;

import java.util.List;
import models.Team;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;


public class Teams extends Controller {
	public static void index() {
		List<Team> entities = models.Team.all().fetch();
		render(entities);
	}

	public static void create(Team entity) {
		render(entity);
	}

	public static void show(java.lang.Long id) {
    Team entity = Team.findById(id);
		render(entity);
	}

	public static void edit(java.lang.Long id) {
    Team entity = Team.findById(id);
		render(entity);
	}

	public static void delete(java.lang.Long id) {
    Team entity = Team.findById(id);
    entity.delete();
		index();
	}
	
	public static void save(@Valid Team entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@create", entity);
		}
    entity.save();
		flash.success(Messages.get("scaffold.created", "Team"));
		index();
	}

	public static void update(@Valid Team entity) {
		if (validation.hasErrors()) {
			flash.error(Messages.get("scaffold.validation"));
			render("@edit", entity);
		}
		
      		entity = entity.merge();
		
		entity.save();
		flash.success(Messages.get("scaffold.updated", "Team"));
		index();
	}

}
