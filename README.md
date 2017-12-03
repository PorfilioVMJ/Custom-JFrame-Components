# Custom JFrame Components
Adds custom JFrame components for creating applications
This adds new components for your applications

# Current New Components
  -EditorMenuBar (Currently still adding features)
  
  -MTextArea

# Example class
```
        EditorMenuBar menuBar;
        MTextArea textArea;
        JScrollPane pane;

        public MyClass(){
            this.setTitle("Test Notepad");
            this.setSize(1280, 720);
            this.setLocationRelativeTo(null);

            textArea = new MTextArea();
            menuBar = new EditorMenuBar(this, textArea);
            pane = new JScrollPane(textArea);

            this.setJMenuBar(menuBar);
            this.add(pane);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }

        public static void main(String[] args){
            new ComponentTester();
        }
```
##![Result](https://raw.githubusercontent.com/PorfilioVMJ/Custom-JFrame-Components/master/vmjlabs/examples/example1.png)
