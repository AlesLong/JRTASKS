package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Controller {

    private Model model;

    private UsersView usersView;
    private EditUserView editUserView;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;

    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(getModel().getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(getModel().getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(getModel().getModelData());
    }

    public void onUserDelete(long id) {
        model.deleteUserById(id);
        onShowAllUsers();
    }

    public void onUserChange(String name, long id, int level) {
        model.changeUserData(name, id, level);
        onShowAllUsers();
    }
}
