FROM python:3.8-slim-buster
WORKDIR .
COPY requirements.txt requirements.txt
RUN pip3 install pickle-mixin
RUN pip3 install -U scikit-learn scipy matplotlib
RUN pip3 install -r requirements.txt
COPY . .
EXPOSE 5000
CMD [ "python", "app.py","--host=0.0.0.0"]