package principal;

import javax.swing.*;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.awt.*;

public class TareaOpengl extends JFrame {

	private long window;
	FlowLayout miFlowLayout;

	public TareaOpengl() {
		super("Tarea Opengl");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);

		miFlowLayout = new FlowLayout(FlowLayout.CENTER, 30, 130);
		setLayout(miFlowLayout);

		JButton boton1 = new JButton("Triángulo");
		JButton boton2 = new JButton("Cuadrado");
		JButton boton3 = new JButton("Círculo");

		boton1.addActionListener(new BotonTrianguloListener());
		boton2.addActionListener(new BotonCuadradoListener());
		boton3.addActionListener(new BotonCirculoListener());

		add(boton1);
		add(boton2);
		add(boton3);

	}

	public static void main(String[] args) {
		TareaOpengl ventana = new TareaOpengl();
		ventana.setVisible(true);
	}

	void crearVentanaRenderizado() {
		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

		window = glfwCreateWindow(1200, 1200, "Tarea Programacion Avanzada II", NULL, NULL);
		if (window == NULL)
			throw new RuntimeException("Failed to create the GLFW window");

		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
	}

	void dibujarCirculo() {
		GL.createCapabilities();

		glClearColor(0.3f, 0.3f, 0.3f, 0.0f);

		GL11.glScalef(0.5f, 0.5f, 0.5f);

		while (!glfwWindowShouldClose(window)) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
			GL11.glColor3f(0.0f, 0.0f, 1.0f); // Rojo
			GL11.glVertex2f(0.0f, 0.0f);
			GL11.glVertex2f(0.0f, 1.0f);
			GL11.glVertex2f(-0.383f, 0.924f);
			GL11.glVertex2f(-0.707f, 0.707f);
			GL11.glVertex2f(-0.924f, 0.383f);
			GL11.glVertex2f(-1.0f, 0.0f);
			GL11.glVertex2f(-0.924f, -0.383f);
			GL11.glVertex2f(-0.707f, -0.707f);
			GL11.glVertex2f(-0.383f, -0.924f);
			GL11.glVertex2f(0.0f, -1.0f);
			GL11.glVertex2f(0.383f, -0.924f);
			GL11.glVertex2f(0.707f, -0.707f);
			GL11.glVertex2f(0.924f, -0.383f);
			GL11.glVertex2f(1.0f, 0.0f);
			GL11.glVertex2f(0.924f, 0.383f);
			GL11.glVertex2f(0.707f, 0.707f);
			GL11.glVertex2f(0.383f, 0.924f);
			GL11.glVertex2f(0.0f, 1.0f);
			GL11.glEnd();

			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}
	
	void dibujarCuadrado() {
		GL.createCapabilities();

		glClearColor(0.3f, 0.3f, 0.3f, 0.0f);

		GL11.glScalef(0.5f, 0.5f, 0.5f);

		while (!glfwWindowShouldClose(window)) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
			GL11.glColor3f(0.0f, 1.0f, 0.0f); // Rojo
			GL11.glVertex2f(1.0f, -1.0f);
			GL11.glVertex2f(1.0f, 1.0f);
			GL11.glVertex2f(-1.0f, 1.0f);
			GL11.glVertex2f(-1.0f, -1.0f);
			GL11.glEnd();

			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}
	
	 void dibujarTriangulo() {
		GL.createCapabilities();

		glClearColor(0.3f, 0.3f, 0.3f, 0.0f);

		GL11.glScalef(0.5f, 0.5f, 0.5f);

		while (!glfwWindowShouldClose(window)) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
			GL11.glColor3f(1.0f, 0.0f, 0.0f); // Rojo
			GL11.glVertex2f(0.0f, 1.0f);
			GL11.glVertex2f(0.866f, -0.500f);
			GL11.glVertex2f(-0.866f, -0.500f);
			GL11.glEnd();

			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}

}
