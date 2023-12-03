
package procedimentos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class RoundButton extends JButton {

    private Color startColor = new Color(240, 240, 240);
    private Color endColor = new Color(200, 200, 200);

    public RoundButton() {
        super();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setPreferredSize(new Dimension(100, 40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);
        g2d.setPaint(gradient);
        g2d.fillRoundRect(0, 0, width, height, 20, 20);

        g2d.setColor(getForeground());
        g2d.drawRoundRect(0, 0, width - 1, height - 1, 20, 20);

        g2d.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Remove a borda padrão para evitar sobreposição com a pintura personalizada
    }

    @Override
    public boolean contains(int x, int y) {
        // Mantenha a lógica de clique do botão conforme necessário
        return super.contains(x, y);
    }
}
