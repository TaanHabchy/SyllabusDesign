package com.example.application.views.creator;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Creator")
@Route(value = "creator", layout = MainLayout.class)
public class CreatorView extends VerticalLayout {

    public CreatorView() {


        Paragraph p1 = new Paragraph("THIS IS WHERE THE SYLLABUS CREATOR IS GONNNA BE");

        add(p1);


    }

}
