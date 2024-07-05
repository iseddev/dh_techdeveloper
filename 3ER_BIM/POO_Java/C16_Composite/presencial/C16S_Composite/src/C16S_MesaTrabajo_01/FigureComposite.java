package C16S_MesaTrabajo_01;

import java.util.ArrayList;
import java.util.List;

public class FigureComposite extends Figure {
    private List<Figure> figureList;

    public FigureComposite() { figureList = new ArrayList<>(); }

    public void addFigure(Figure figure) { figureList.add(figure); }

    @Override
    double calculateArea() {
        double totalArea = 0.0;
        for (Figure figure : figureList) { totalArea += figure.calculateArea(); }
        return totalArea;
    }

    @Override
    public String toString() { return "Figuras: {" + figureList + '}'; }
}