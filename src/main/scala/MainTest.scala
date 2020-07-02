/*
 * Copyright 2020 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.InputStream

import cats.effect._
import models._
import utils.ProtocolUtils

object MainTest extends IOApp {

  private val validator = ProtocolUtils.impl[IO]

  def run(args: List[String]): IO[ExitCode] = {

    //FROM FILE
    val stream: InputStream = getClass.getResourceAsStream("/correctYAML.yaml")
    val text: String        = scala.io.Source.fromInputStream(stream).getLines.mkString
    val pt1: IO[Protocol]   = validator.validateProtocol(Protocol(text), IdlName.OpenAPIYaml)

    IO.delay(println(pt1.unsafeRunSync())).as(ExitCode.Success)

    //FROM STRING
    /*
    val msg =
      """
        |openapi: "3.0.0"
        |info:
        |  version: 1.0.0
        |  title: AnotherPetstore
        |  license:
        |    name: MIT
        |servers:
        |  - url: http://petstore.swagger.io/v1
        |paths:
        |  /pets:
        |    get:
        |      summary: List all pets
        |      operationId: getPets
        |      parameters:
        |        - name: limit
        |          in: query
        |          description: How many items to return at one time
        |          required: false
        |          schema:
        |            type: integer
        |            format: int32
        |        - name: name
        |          in: query
        |          description: Items that contains in name the provided string
        |          required: false
        |          schema:
        |            type: string
        |      responses:
        |        '200':
        |          description: A paged array of pets
        |          content:
        |            application/json:
        |              schema:
        |                $ref: "#/components/schemas/Pets"
        |    post:
        |      summary: Create a pet
        |      operationId: createPet
        |      requestBody:
        |        required: true
        |        content:
        |          application/json:
        |            schema:
        |              $ref: "#/components/schemas/NewPet"
        |      responses:
        |        '201':
        |          description: Null response
        |        '400':
        |          description: Duplicated response
        |          content:
        |            application/json:
        |              schema:
        |                type: string
        |        default:
        |          description: unexpected error
        |          content:
        |            application/json:
        |              schema:
        |                $ref: "#/components/schemas/PetError"
        |  /pets/{petId}:
        |    put:
        |      summary: Update a pet
        |      parameters:
        |        - name: petId
        |          in: path
        |          required: true
        |          description: The id of the pet to update
        |          schema:
        |            type: integer
        |      operationId: updatePet
        |      requestBody:
        |        required: true
        |        content:
        |          application/json:
        |            schema:
        |              $ref: "#/components/schemas/UpdatePet"
        |      responses:
        |        '200':
        |          description: Null response
        |    delete:
        |      summary: Delete a pet
        |      operationId: deletePet
        |      parameters:
        |        - name: petId
        |          in: path
        |          required: true
        |          description: The id of the pet to delete
        |          schema:
        |            type: integer
        |      responses:
        |        '200':
        |          description: Null response
        |    get:
        |      summary: Info for a specific pet
        |      operationId: getPet
        |      parameters:
        |        - name: petId
        |          in: path
        |          required: true
        |          description: The id of the pet to retrieve
        |          schema:
        |            type: integer
        |      responses:
        |        '200':
        |          description: Expected response to a valid request
        |          content:
        |            application/json:
        |              schema:
        |                $ref: "#/components/schemas/Pet"
        |        '404':
        |          description: Not found response
        |          content:
        |            application/json:
        |              schema:
        |                type: string
        |        default:
        |          description: unexpected error
        |          content:
        |            application/json:
        |              schema:
        |                $ref: "#/components/schemas/PetError"
        |components:
        |  schemas:
        |    Pet:
        |      required:
        |        - id
        |        - name
        |      properties:
        |        id:
        |          type: integer
        |          format: int64
        |        name:
        |          type: string
        |        tag:
        |          type: string
        |    NewPet:
        |      required:
        |        - name
        |      properties:
        |        name:
        |          type: string
        |        tag:
        |          type: string
        |    UpdatePet:
        |      required:
        |        - tag
        |      properties:
        |        tag:
        |          type: string
        |    Pets:
        |      type: array
        |      items:
        |        $ref: "#/components/schemas/Pet"
        |    PetError:
        |      required:
        |        - code
        |        - message
        |      properties:
        |        code:
        |          type: integer
        |          format: int32
        |        message:
        |          type: string
        |    Owner:
        |      required:
        |        - person
        |      properties:
        |        address:
        |          type: string
        |        person:
        |          type: object
        |          required:
        |            - name
        |            - surname
        |          properties:
        |            name:
        |              type: string
        |            surname:
        |              type: string
        |            age:
        |              type: integer
        |""".stripMargin

    val pt2: IO[Protocol] = validator.validateProtocol(Protocol(msg), IdlName.OpenAPIYaml)

    IO.delay(println(pt2.unsafeRunSync())).as(ExitCode.Success)*/

  }

}
