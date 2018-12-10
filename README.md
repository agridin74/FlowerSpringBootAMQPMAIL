# Пример обмена сообщениями с использованием RabbitMQ Mail сервера в микросервисной архитектуре
Spring BOOT RabbitMQ send Mail 
## RabbitMQ используем docker контейнер
	* ~$ docker run -d --hostname my_rabbit --name some-rabbit -p 15672:15762 -p 5672:5672 rabbitmq:3-management - запуск
	* ~$ docker ps  - реестр работающих контейнеров
	* ~$ docker inspect CONTAINER_ID -  информация о контейнере
	* ~$ docker inspect -f '{{.Name}} - {{.NetworkSettings.IPAddress }}' $(docker ps -aq) - просмотр IP адреса контейнера
	* ~$ docker ps -a - реестр всех контейнеров в системе
	* ~$ docker stop some-rabbit - останов контейнера
	* ~$ docker rm $(docker ps -a -f status=exited -q) -удаление остановленного
## Mail Server для тестирования 
	* используется FakeSMTP (http://nilhcem.com/FakeSMTP/)
