import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;
/*
<html>
<applet code = "SortingApplet" width=1366 height=768></applet>
</html>
*/

public class SortingApplet extends Applet implements ActionListener {
    int maxY=600;
    int offset=10;
    int off=10;
    int xi=0, xj=0;
    int elements;
    int randArr[]=new int[500];
    boolean laidOut=false;
    Button generateButton;
    Button bubbleButton;
    Button insertionButton;
    Button selectionButton;
    Button heapButton;
    Button mergeButton;
    Button shellButton;
    Button radixButton;
    TextField textField;
    Label l1, l2;
    Color bg=Color.decode("#d3d3d3");
    Color c=Color.decode("#add8e6");

    public void init(){
        setLayout(null);
        setBackground(bg);
        generateButton=new Button("Generate Array");
        generateButton.setBackground(c);
        bubbleButton=new Button("Bubble Sort");
        bubbleButton.setBackground(c);
        insertionButton=new Button("Insertion Sort");
        insertionButton.setBackground(c);
        selectionButton=new Button("Selection Sort");
        selectionButton.setBackground(c);
        heapButton=new Button("Heap Sort");
        heapButton.setBackground(c);
        mergeButton=new Button("Merge Sort");
        mergeButton.setBackground(c);
        shellButton=new Button("Shell Sort");
        shellButton.setBackground(c);
        radixButton=new Button("Radix Sort");
        radixButton.setBackground(c);
        textField=new TextField("50");
        l1=new Label("Elements");
        l2=new Label("(less than 180)");


        generateButton.addActionListener(this);
        bubbleButton.addActionListener(this);
        insertionButton.addActionListener(this);
        selectionButton.addActionListener(this);
        heapButton.addActionListener(this);
        mergeButton.addActionListener(this);
        shellButton.addActionListener(this);
        radixButton.addActionListener(this);
        textField.addActionListener(this);

        add(generateButton);
        add(bubbleButton);
        add(insertionButton);
        add(selectionButton);
        add(heapButton);
        add(mergeButton);
        add(shellButton);
        add(radixButton);
        add(textField);
        add(l1);
        add(l2);

    }

    public void actionPerformed(ActionEvent e)	{
        String action=e.getActionCommand();
        Graphics g=getGraphics();


        if(action.equals("Generate Array"))
        {
            String text=textField.getText();
            elements=Integer.parseInt(text);
            if(elements>130)
            {
                elements=130;
                textField.setText("130");
            }
            generateRandomArray(g);
        }
        else if(action.equals("Bubble Sort"))
        {

            bubbleSort(g);
        }
        else if(action.equals("Insertion Sort"))
        {
            insertionSort(g);
        }
        else if(action.equals("Selection Sort"))
        {
            selectionSort(g);
        }
        else if(action.equals("Heap Sort")) {
            heapSort(g);
        }
        else if(action.equals("Merge Sort")) {

            sort(randArr, 0, elements-1,g);
        }
        else if(action.equals("Shell Sort")) {
            shellSort(randArr, g);
        }
        else if(action.equals("Radix Sort")) {
            radixSort(randArr, elements, g);
        }

    }

    public void paint(Graphics g){
        g.setColor(Color.black);
        if(!laidOut)
        {
            //Note:Please change these coordinates according to your monitor's resolution...
            int y_ccor1 = 600;
            int y_coor2 = 650;

            int x_start = 300;
            int x_offset = 120;
            //Note:Please change these coordinates according to your monitor's resolution...

            l1.setLocation(60,y_ccor1);
            l1.setSize(60,20);

            textField.setLocation(120,y_ccor1);
            textField.setSize(50,20);

            l2.setLocation(180,800);
            l2.setSize(110,20);

            generateButton.setLocation(60,y_coor2);
            generateButton.setSize(100,30);

            bubbleButton.setLocation(x_start,y_coor2);
            bubbleButton.setSize(100,30);

            insertionButton.setLocation(x_start + x_offset,y_coor2);
            insertionButton.setSize(100,30);

            selectionButton.setLocation(x_start + 2*x_offset,y_coor2);
            selectionButton.setSize(100,30);

            heapButton.setLocation(x_start + 3*x_offset,y_coor2);
            heapButton.setSize(100,30);

            mergeButton.setLocation(x_start + 4*x_offset,y_coor2);
            mergeButton.setSize(100,30);

            shellButton.setLocation(x_start + 5*x_offset,y_coor2);
            shellButton.setSize(100,30);

            radixButton.setLocation(x_start + 6*x_offset,y_coor2);
            radixButton.setSize(100,30);

            laidOut=true;
        }
    }

    public void generateRandomArray(Graphics g)	{
        clear();
        for(int i=0;i<elements;i++)
        {
            Random rand=new Random();
            int y=maxY-rand.nextInt(590)+10;
            randArr[i]=y;
        }

        for(int k=0;k<elements;k++)
        {
            g.fillRect(offset,randArr[k],5,1000);
            offset+=off;
        }
        offset=off;

    }


    public void bubbleSort(Graphics g){
        for(int i=1;i<elements;i++)
        {
            for(int j=0;j<elements-1;j++)
            {
                if(randArr[j]>randArr[j+1])
                {

                    int temp=randArr[j];
                    randArr[j]=randArr[j+1];
                    randArr[j+1]=temp;
                    clear();
                    for(int k=0;k<elements;k++)
                    {
                        g.fillRect(offset,randArr[k],5,1000);
                        offset+=off;
                    }

                    offset=off;
                    try{Thread.sleep(2);}
                    catch(Exception e)
                    {}
                }
            }
        }
    }

    public void insertionSort(Graphics g){
        for(int i=0;i<=elements;i++)
        {
            for(int j=i+1;j>0;j--)
            {
                if(randArr[j]>randArr[j-1]) {
                    int temp=randArr[j];
                    randArr[j]=randArr[j-1];
                    randArr[j-1]=temp;
                    clear();
                    for(int k=0;k<elements;k++)
                    {
                        g.fillRect(offset,randArr[k],5,1000);
                        offset+=off;
                    }

                    offset=off;
                    try{Thread.sleep(2);}
                    catch(Exception e)
                    {}
                }
            }
        }
    }

    public void selectionSort(Graphics g){
        for(int i=0;i<elements;i++) {
            int min=randArr[i];
            int index=0;
            int temp=0;
            boolean found=false;
            for(int j=i;j<elements;j++){
                if(randArr[j]<min) {
                    min=randArr[j];
                    index=j;
                    found=true;
                }
            }
            if(found) {
                temp=randArr[index];
                randArr[index]=randArr[i];
                randArr[i]=temp;
                clear();
                for(int k=0;k<elements;k++)
                {
                    g.fillRect(offset,randArr[k],5,1000);
                    offset+=off;
                }
                offset=off;
                try{Thread.sleep(100);}
                catch(Exception e)
                {}
            }
        }
    }

    public void heapSort(Graphics g){

        int n = elements;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(randArr, n, i, g);

        for (int i=n-1; i>=0; i--)
        {
            int temp = randArr[0];
            randArr[0] = randArr[i];
            randArr[i] = temp;

            heapify(randArr, i, 0, g);
        }
    }
    public void heapify(int arr[], int n, int i, Graphics g)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            clear();
            for(int k=0;k<elements;k++)
            {
                g.fillRect(offset,randArr[k],5,1000);
                offset+=off;
            }
            offset=off;
            try{Thread.sleep(25);}
            catch(Exception e)
            {}

            heapify(arr, n, largest, g);
        }
        if(i==0) {
            clear();
            for(int k=0;k<elements;k++)
            {
                g.fillRect(offset,randArr[k],5,1000);
                offset+=off;
            }
            offset=off;
            try{Thread.sleep(25);}
            catch(Exception e)
            {}
        }
    }

    public void merge(int randArr[], int l, int m, int r, Graphics g)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = randArr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = randArr[m + 1+ j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                randArr[k] = L[i];
                i++;
            }
            else
            {
                randArr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            randArr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            randArr[k] = R[j];
            j++;
            k++;
        }
        clear();
        for(int K=0;K<elements;K++)
        {
            g.fillRect(offset,randArr[K],5,1000);
            offset+=off;
        }
        offset=off;
        try{Thread.sleep(25);}
        catch(Exception e)
        {}
    }
    public void sort(int randArr[], int l, int r, Graphics g)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            sort(randArr, l, m, g);
            sort(randArr , m+1, r, g);

            merge(randArr, l, m, r, g);
        }
        clear();
        for(int k=0;k<elements;k++)
        {
            g.fillRect(offset,randArr[k],5,1000);
            offset+=off;
        }
        offset=off;
        try{Thread.sleep(25);}
        catch(Exception e)
        {}
    }

    public void shellSort(int arr[], Graphics g)
    {
        int n = elements;
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    clear();
                    for(int k=0;k<elements;k++)
                    {
                        g.fillRect(offset,randArr[k],5,1000);
                        offset+=off;
                    }
                    offset=off;
                    try{Thread.sleep(25);}
                    catch(Exception e)
                    {}
                }

                arr[j] = temp;
            }
        }
    }

    public int getMax(int randArr[], int n)
    {
        int mx = randArr[0];
        for (int i = 1; i < n; i++)
            if (randArr[i] > mx)
                mx = randArr[i];
        return mx;
    }
    public void countSort(int randArr[], int n, int exp, Graphics g)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
        {
            count[ (randArr[i]/exp)%10 ]++;

        }

        for (i = 1; i < 10; i++)
        {
            count[i] += count[i - 1];

        }

        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (randArr[i]/exp)%10 ] - 1] = randArr[i];
            count[ (randArr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++){
            randArr[i] = output[i];
            clear();
            for(int k=0;k<elements;k++)
            {
                g.fillRect(offset,randArr[k],5,1000);
                offset+=off;
            }

            offset=off;
            try{Thread.sleep(25);}
            catch(Exception e)
            {}
        }
    }
    public void radixSort(int randArr[], int n, Graphics g)
    {
        int m = getMax(randArr, n);

        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(randArr, n, exp, g);
    }

    public void clear(){
        Graphics g=getGraphics();
        Dimension d=getSize();
        Color c=getBackground();
        g.setColor(c);
        g.fillRect(0,0,d.width,d.height);
    }
}
